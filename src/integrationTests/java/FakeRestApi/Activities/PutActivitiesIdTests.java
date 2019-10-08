package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import FakeRestApi.Utils.Builders;
import FakeRestApi.Utils.Categorias.Funcionality;
import FakeRestApi.Utils.Categorias.Integrity;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class PutActivitiesIdTests {

    @Test
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(BLOCKER)
    @Category(Integrity.class)
    public void deveValidarIntegridadeDoEndPoint() {

        final Integer ID = 31;

        given().
            contentType(ContentType.JSON).
            body(Builders.getAnexoActvities(
                31,
                "Mergulho com tubarões",
                "2019-10-07T15:19:40.223Z",
                false)).
            when().
            put("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all();

    }

    @Test
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(CRITICAL)
    @Category(Funcionality.class)
    public void deveAtualizarListaDeAtividadeOpção01() {

        final Integer ID = 31;

        given().
            contentType(ContentType.JSON).
            body(Builders.getAnexoActvities(
                ID,
                "Mergulho com Tubarões",
                "2019-10-07T15:19:40.223Z",
                false)).
            when().
            post("http://fakerestapi.azurewebsites.net/api/Activities").
            then();

        given().
            contentType(ContentType.JSON).
                body(Builders.getAnexoActvities(
                    ID,
                    "Mergulho com Pirãnhas",
                    "2019-10-07T15:19:40.223Z",
                    false)).
        when().
            put("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
        then().
            statusCode(200).log().all();

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all().
            body("ID", equalTo(30)).
            body("Title", equalTo("Mergulho com Pirãnhas")).
            body("DueDate", is(notNullValue())).
            body("Completed", is(true));

        /**
         * A OPÇÃO 01 SE UTILIZA DE UM CONSTRUTOR QUE ESTÁ ALOCADO DENTRO DE UTILS, NA CLASSE BUILDER
         */

    }

    @Test
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(CRITICAL)
    @Category(Funcionality.class)
    public void deveAtualizarListaDeAtividadeOpção02() {

        final Integer ID = 30;

        String anexoActivities = "{"
            + "\" ID \": \"31\", "
            + "\"Title\": \"Mergulho com Pirãnhas\", "
            + "\"DueDate\": "
            + "\"2019-10-07T15:19:40.223Z\", "
            + "\"Completed\": \"true\" }";

        given().
            contentType(ContentType.JSON).
                body(anexoActivities).
            when().
            put("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all();

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all().
            body("ID", equalTo(30)).
            body("Title", equalTo("Mergulho com Pirãnhas")).
            body("DueDate", is(notNullValue())).
            body("Completed", is(true));

        /**
         * A OPÇÃO 02 SE UTILIZA DE UM JSON ESTRUTURADO COMO STRING, SEM DEPENDÊNCIA DE OUTRAS CLASSES
         */

    }

    /**
     * PARA VALIDAÇÃO DE UM PUT EM SISTEMAS QUE NÃO PODEM SER ALTERADOS DADOS É NECESSÁRIO EXECUTAR UM
     * POST INCIALMENTE PARA INSERIR UM NOVO DADO
     * PARA VALIDAÇÃO DE UM PUT EM SISTEMAS QUE PODEM SER ALTERADOS DADOS NÃO É PRECISO
     * MAS PARA AMBOS OS CASOS UM GET APÓS O PUT É NECESSÁRIO PARA CONFIRMAR SE O DADO FOI ALTERADO CORRETAMENTE
     */

}
