package FakeRestApi.Activities;

import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import FakeRestApi.Utils.Categorias.Contract;
import FakeRestApi.Utils.Categorias.Funcionality;
import FakeRestApi.Utils.Categorias.Integrity;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class GetActivitiesIdTests {

    @Test
    @DisplayName("")
    @Description("")
    @Severity(BLOCKER)
    @Category(Integrity.class)
    public void deveValidarIntegridadeDoEndPointQuandoExecutadaRequisicao() {

        final Integer ID = 30;

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all();

    }

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    @Category(Contract.class)
    public void deveValidarContratoDoEndPointQuandoExecutadaRequisicao() {

        final Integer ID = 30;

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all().
            assertThat().body(matchesJsonSchemaInClasspath("schema_GetAtivitiesId.json"));

    }

    @Test
    @DisplayName("")
    @Description("")
    @Severity(NORMAL)
    @Category(Funcionality.class)
    public void deveTrazerAtividadeCorrespondenteAoIdQuandoExecutadaRequisicao() {

        final Integer ID = 30;

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all().
            body("ID", equalTo(30)).
            body("Title", equalTo("Activity 30")).
            body("DueDate", is(notNullValue())).
            //body("DueDate", equalTo("2019-10-09T01:04:21.9720062+00:00")).
            //body("DueDate", contains("2019")).
                body("Completed", is(true));

    }

}
