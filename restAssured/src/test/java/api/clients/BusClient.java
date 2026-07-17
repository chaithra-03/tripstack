package api.clients;

import config.Endpoints;
import api.specs.RequestSpecs;
import io.restassured.response.Response;
import models.BusSearchRequest;
import models.BusSeatsRequest;

import static io.restassured.RestAssured.given;

public class BusClient {

    public Response search(BusSearchRequest request) {
        return given()
                .spec(RequestSpecs.authenticated())
                .queryParam("from", request.from())
                .queryParam("to", request.to())
                .queryParam("date", request.date())
                .when()
                .get(Endpoints.BUS_SEARCH);
    }

    public Response seats(BusSeatsRequest request) {
        return given()
                .spec(RequestSpecs.authenticated())
                .when()
                .get(String.format(Endpoints.BUS_SEATS, request.busId()));
    }

}
