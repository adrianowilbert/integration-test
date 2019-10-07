package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import FakeRestApi.Utils.Builders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class PutActivitiesIdTests {

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    public void deveAtualizarListaDeAtividadesQuandoExecutadaRequisicaoOpção01() {

        final Integer ID = 30;

        given().
            contentType(ContentType.JSON).
                body(Builders.getAnexoActvities(31, "Mergulho com tubarões", "2019-10-07T15:19:40.223Z", false)).
        when().
            put("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
        then().
            statusCode(200).log().all();

    }

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    public void deveAtualizarListaDeAtividadesQuandoExecutadaRequisicaoOpção02() {

        final Integer ID = 30;

        String anexoActivities = "{\" ID \": \"31\", \"Title\": \"string\", \"DueDate\": \"2019-10-07T15:19:40.223Z\", \"Completed\": \"true\" }";

        given().
            contentType(ContentType.JSON).
                body(anexoActivities).
            when().
            put("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all();

    }

}
