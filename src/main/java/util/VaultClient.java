package util;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VaultClient {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Map<String, String> cache = new ConcurrentHashMap<>();

    private static final String VAULT_ADDR = System.getProperty("vaultAddr", "https://127.0.0.1:8200");
    private static final String VAULT_TOKEN = System.getProperty("vaultToken", "your_token");

    public static String getSecret(String path, String key) {
        String cacheKey = path + ":" + key;
        if (cache.containsKey(cacheKey)) return cache.get(cacheKey);

        try {
            String fullPath = "/v1/secret/data/" + path;

            Response response = RestAssured.given()
                    .relaxedHTTPSValidation() // отключаем SSL проверку
                    .baseUri(VAULT_ADDR)
                    .header("X-Vault-Token", VAULT_TOKEN)
                    .get(fullPath);

            if (response.statusCode() != 200) {
                throw new RuntimeException("Vault вернул статус: " + response.statusCode());
            }

            String body = response.getBody().asString();

            JsonNode json = mapper.readTree(body);
            String value = json.get("data").get("data").get(key).asText();

            cache.put(cacheKey, value);
            return value;

        } catch (Exception e) {
            throw new RuntimeException("Не удалось получить секрет из Vault: " + path + ":" + key, e);
        }
    }
}
