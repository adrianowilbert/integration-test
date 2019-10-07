package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

import org.junit.Test;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import com.sun.xml.internal.bind.v2.model.core.ID;

import FakeRestApi.Utils.Builders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class PostActivitiesTests {

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    public void deveInserirAtividadesQuandoExecutadaRequisicaoOpção01() {

        given().
            contentType(ContentType.JSON).
                body(Builders.getAnexoActvities(31, "Mergulho com tubarões", "2019-10-07T15:19:40.223Z", false)).
        when().
            post("http://fakerestapi.azurewebsites.net/api/Activities").
        then().
            statusCode(200).log().all();

    }

    @Test
    @DisplayName("")
    @Description("")
    @Severity(CRITICAL)
    public void deveInserirAtividadesQuandoExecutadaRequisicaoOpção02() {

        String anexoActivities = "{\" ID \": \"31\", \"Title\": \"string\", \"DueDate\": \"2019-10-07T15:19:40.223Z\", \"Completed\": \"true\" }";

        given().
            contentType(ContentType.JSON).
                body(anexoActivities).
            when().
            post("http://fakerestapi.azurewebsites.net/api/Activities").
            then().
            statusCode(200).log().all();

    }

}
