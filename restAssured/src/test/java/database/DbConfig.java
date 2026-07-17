package database;

import config.Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DbConfig {

	private DbConfig() {
	}

	public static Connection openConnection() throws SQLException {
		String url = Config.DB_URL;
		return DriverManager.getConnection(
				url,
				Config.DB_USERNAME,
				Config.DB_PASSWORD
		);
	}
}
