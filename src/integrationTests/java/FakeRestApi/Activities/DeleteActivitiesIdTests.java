package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

import org.junit.Test;

import FakeRestApi.Utils.Builders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class DeleteActivitiesIdTests {

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    public void deveDeletarAtividadeQuandoExecutadaRequisicao() {

        final Integer ID = 31;

        given().
            contentType(ContentType.JSON).
        when().
            post("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
        then().
            statusCode(200).log().all();

    }

}
