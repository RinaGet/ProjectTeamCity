import org.junit.jupiter.api.Test;
import util.VaultClient;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class VaultTest {

    @Test
    void testGetTeamCityTokenFromVault(){
        String secretPath = System.getProperty("vaultSecretPath", "secret/teamcity");
        String secretKey = System.getProperty("vaultKey", "token");

        String value = VaultClient.getSecret(secretPath, secretKey);

        assertNotNull(value, "Секрет не должен быть null");
        assertFalse(value.isBlank(), "Секрет не должен быть пустым");

        System.out.println("Получено значение из Vault по ключу '" + secretKey + "': " + mask(value));
    }

    // маскировка чувствительных значений в логе
    private String mask(String value) {
        return value.length() <= 4 ? "****" : value.substring(0, 2) + "***" + value.substring(value.length() - 2);
    }
}
