package api.clients;

import api.specs.RequestSpecs;
import config.Endpoints;
import io.restassured.response.Response;
import models.LoginRequest;

import static io.restassured.RestAssured.given;

public class AuthClient {

    public Response login(LoginRequest request) {
        return given()
                .spec(RequestSpecs.unauthenticated())
                .body(request)
                .when()
                .post(Endpoints.AUTH_LOGIN);
    }

}
