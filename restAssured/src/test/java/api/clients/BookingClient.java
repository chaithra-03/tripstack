package api.clients;

import api.specs.RequestSpecs;
import config.Endpoints;
import io.restassured.response.Response;
import models.BookingRequest;
import models.BookingIdRequest;
import models.BookingPnrRequest;

import static io.restassured.RestAssured.given;

public class BookingClient {
    public Response createBooking(BookingRequest request) {
        return given()
                .spec(RequestSpecs.authenticated())
                .body(request)
                .when()
                .post(Endpoints.BOOKINGS);
    }

    public Response pay(BookingIdRequest request) {
        return given()
                .spec(RequestSpecs.authenticated())
                .when()
                .post(String.format(Endpoints.BOOKING_PAY, request.bookingId()));
    }

    public Response confirm(BookingIdRequest request) {
        return given()
                .spec(RequestSpecs.authenticated())
                .when()
                .post(String.format(Endpoints.BOOKING_CONFIRM, request.bookingId()));
    }

    public Response listBookings() {
        return given()
                .spec(RequestSpecs.authenticated())
                .when()
                .get(Endpoints.BOOKINGS);
    }

    public Response resetNamespace() {
        return given()
                .spec(RequestSpecs.authenticated())
                .when()
                .post(Endpoints.RESET);
    }

    public Response readBookingByPnr(BookingPnrRequest request) {
        return given()
                .spec(RequestSpecs.authenticated())
                .when()
                .get(String.format(Endpoints.BOOKING_BY_PNR, request.pnr()));
    }
}
