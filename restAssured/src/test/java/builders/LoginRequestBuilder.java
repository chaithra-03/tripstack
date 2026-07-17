package builders;

import config.Config;
import models.LoginRequest;

public class LoginRequestBuilder {

    private final LoginRequest request = new LoginRequest();

    public LoginRequestBuilder() {
    }

    public LoginRequestBuilder withEmail(String email) {
        request.setEmail(email);
        return this;
    }

    public LoginRequestBuilder withPassword(String password) {
        request.setPassword(password);
        return this;
    }

    public LoginRequestBuilder withDefaultUser() {
        request.setEmail(Config.USER_EMAIL);
        request.setPassword(Config.USER_PASSWORD);
        return this;
    }

    public LoginRequest build() {
        return request;
    }

}