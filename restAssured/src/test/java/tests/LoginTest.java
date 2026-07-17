package tests;

import api.clients.AuthClient;
import api.specs.ResponseSpecs;
import builders.LoginRequestBuilder;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.notNullValue;

class LoginTest {

    private final AuthClient authClient = new AuthClient();

    @Test
    void shouldLoginSuccessfully() {

        Response response = authClient.login(
                new LoginRequestBuilder()
                        .withDefaultUser()
                        .build());

        response.then()
                .spec(ResponseSpecs.success())
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/login-schema.json"))
                .body("token", notNullValue());

    }
}
