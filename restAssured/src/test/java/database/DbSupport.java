package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class DbSupport {

	public Map<String, Object> findBookingByPnr(String pnr) {

		try (Connection connection = DbConfig.openConnection()) {

			String tableName = findBookingTable(connection);
			String pnrColumn = findColumn(connection, tableName, List.of("pnr"));

			String sql = SqlQueries.findBookingByPnr(tableName, pnrColumn);

			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, pnr);

				try (ResultSet resultSet = statement.executeQuery()) {
					if (!resultSet.next()) {
						throw new IllegalStateException("No booking row found for PNR: " + pnr);
					}

					return toMap(resultSet);
				}
			}

		} catch (SQLException exception) {
			throw new IllegalStateException("Failed to read booking row from database", exception);
		}
	}

	public String readString(Map<String, Object> row, String... keys) {

		for (String key : keys) {
			for (Map.Entry<String, Object> entry : row.entrySet()) {
				if (normalize(entry.getKey()).equals(normalize(key)) && entry.getValue() != null) {
					return String.valueOf(entry.getValue());
				}
			}
		}

		return null;
	}

	private String findBookingTable(Connection connection) throws SQLException {

		String tableName = querySingleValue(connection, SqlQueries.FIND_BOOKING_TABLE_BY_NAME);

		if (tableName == null) {
			tableName = querySingleValue(connection, SqlQueries.FIND_BOOKING_TABLE_BY_COLUMNS);
		}

		if (tableName != null) {
			return tableName;
		}

		throw new IllegalStateException("Unable to locate a booking table in the database");
	}

	private String querySingleValue(Connection connection, String sql) throws SQLException {

		try (PreparedStatement statement = connection.prepareStatement(sql);
			 ResultSet resultSet = statement.executeQuery()) {

			if (resultSet.next()) {
				return resultSet.getString(1);
			}
		}

		return null;
	}

	private String findColumn(Connection connection, String tableName, List<String> keywords) throws SQLException {

		try (PreparedStatement statement = connection.prepareStatement(
				SqlQueries.findColumnByKeywords(keywords.size()))) {
			statement.setString(1, tableName);

			for (int index = 0; index < keywords.size(); index++) {
				statement.setString(index + 2, "%" + keywords.get(index).toLowerCase(Locale.ROOT) + "%");
			}

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString(1);
				}
			}
		}

		throw new IllegalStateException("Unable to resolve a column in table: " + tableName);
	}

	private Map<String, Object> toMap(ResultSet resultSet) throws SQLException {

		ResultSetMetaData metadata = resultSet.getMetaData();
		int columnCount = metadata.getColumnCount();
		Map<String, Object> row = new LinkedHashMap<>();

		for (int column = 1; column <= columnCount; column++) {
			row.put(metadata.getColumnLabel(column), resultSet.getObject(column));
		}

		return row;
	}

	private String normalize(String value) {

		return value == null ? "" : value.replace("_", "").toLowerCase(Locale.ROOT);
	}
}
