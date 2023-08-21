package integrationTests.tests.serveRest.login.request;

import static io.restassured.RestAssured.given;

import integrationTests.tests.serveRest.login.payloads.PostLoginPayload;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class PostLoginRequest {

    public static final String PATH = "/login";

    @SneakyThrows
    @Step("Realiza login")
    public Response postLogin(final String email, final String password) {

        return given()
            .body(PostLoginPayload.postLoginPayload(email, password))
            .post(PATH);
    }
}
