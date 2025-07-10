package httpClient;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TeamCityApiClient {
    private static RequestSpecification spec() {
        return RestAssured.given()
                .baseUri(Config.BASE_URI)
                .auth().preemptive().basic(Config.TOKEN, "")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();
    }

    public static Response get(String path) {
        return spec().get(path);
    }

    public static Response post(String path, Object body) {
        return spec().body(body).post(path);
    }
}
