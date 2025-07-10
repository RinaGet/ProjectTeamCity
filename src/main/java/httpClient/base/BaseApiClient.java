package httpClient.base;

import config.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public abstract class BaseApiClient {

    protected RequestSpecification spec() {
        return RestAssured.given()
                .baseUri(Config.BASE_URI)
                .auth().preemptive().basic(Config.TOKEN, "")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().all();
    }

    protected Response get(String path) {
        return spec().get(path);
    }

    protected Response get(String path, Map<String, String> queryParams) {
        return spec().queryParams(queryParams).get(path);
    }

    protected Response post(String path, Object body) {
        return spec().body(body).post(path);
    }

    protected Response put(String path, Object body) {
        return spec().body(body).put(path);
    }

    protected Response delete(String path) {
        return spec().delete(path);
    }
}



