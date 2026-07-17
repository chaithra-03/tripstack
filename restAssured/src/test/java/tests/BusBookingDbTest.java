package tests;

import database.DbSeeder;
import database.DbSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

@Tag("db")
class BusBookingDbTest {

    private final DbSupport dbSupport = new DbSupport();

    @BeforeEach
    void seedDatabase() {

        DbSeeder.seedConfirmedBusBooking();
    }

    @Test
    void shouldReadSeededConfirmedAcSemiSleeperBooking() {

        Map<String, Object> bookingRow = dbSupport.findBookingByPnr(DbSeeder.PNR);

        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "pnr"), equalTo(DbSeeder.PNR));
        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "state"), equalTo("CONFIRMED"));
        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "empId", "emp_id"), equalTo(DbSeeder.EMP_ID));
        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "journeyType", "journey_type"), equalTo("bus"));
        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "inventoryId", "inventory_id"),equalTo(DbSeeder.INVENTORY_ID));
        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "seatIds", "seat_ids"), containsString(DbSeeder.SEAT_ID));
        org.hamcrest.MatcherAssert.assertThat(dbSupport.readString(bookingRow, "refundable"), anyOf(equalTo("true"), equalTo("1")));
    }
}
