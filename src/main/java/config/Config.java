package config;

import util.VaultClient;

public class Config {

    public static final String BASE_URI = System.getProperty("baseUri", "http://localhost:8111");

    public static final String TOKEN = getTokenSafely();

    private static String getTokenSafely() {
        String vaultPath = System.getProperty("vaultSecretPath", "teamcity/token");
        String vaultKey = System.getProperty("vaultKey", "token");

        try {
            String token = VaultClient.getSecret(vaultPath, vaultKey);
            System.out.println("TOKEN получен из Vault");
            return token;
        } catch (Exception e) {
            System.out.println("Не удалось получить токен из Vault. Использую fallback:");
            e.printStackTrace();
            return System.getProperty("token", "default_token");
        }
    }
}
