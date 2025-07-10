package config;

public class Config {
    public static final String BASE_URI = System.getProperty("baseUri", "http://localhost:8111");
    public static final String TOKEN = System.getProperty("token", "default_token");
}
