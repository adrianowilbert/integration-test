package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

import org.junit.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class GetActivitiesTests {

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    public void deveTrazerListaDeAtividadeQuandoExecutadaRequisicao() {

        given().
            contentType(ContentType.JSON).
        when().
            get("http://fakerestapi.azurewebsites.net/api/Activities").
        then().
            statusCode(200).log().all().
            body(not(empty()));

    }

}
