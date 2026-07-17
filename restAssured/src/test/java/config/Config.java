package config;

public final class Config {

    private Config() {
    }

    public static final String BASE_URL = AppConfig.get("BASE_URL");
    public static final String DB_URL = AppConfig.get("DB_URL");
    public static final String DB_USERNAME = AppConfig.get("DB_USERNAME");
    public static final String DB_PASSWORD =AppConfig.get("DB_PASSWORD");
    public static final String USER_EMAIL =AppConfig.get("USER_EMAIL");
    public static final String USER_PASSWORD =AppConfig.get("USER_PASSWORD");

}