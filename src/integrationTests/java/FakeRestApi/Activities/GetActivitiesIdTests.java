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
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(BLOCKER)
    @Category(Integrity.class)
    public void deveValidarIntegridadeDoEndPoint() {

        final Integer ID = 30;

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all();

    }

    @Test
    @DisplayName("Realiza a validação do contrato da aplicação")
    @Description("Deve validar o contrato do endpoint")
    @Severity(CRITICAL)
    @Category(Contract.class)
    public void deveValidarContratoDoEndPoint() {

        final Integer ID = 30;

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all().
            assertThat().body(matchesJsonSchemaInClasspath("schema_GetAtivitiesId"));

        /**
         * PARA GERAR O ARQUIVO JSON É NECESSÁRIO PEGAR O RESPONSE DA REQUISIÇÃO E GERAR ELE NO ENDEREÇO
         * - https://jsonschema.net/
         * APÓS ISSO ALOCAR O ARQUIVO DENTRO DO RESOURCES DO PROJETO
         */

    }

    @Test
    @DisplayName("Realiza a validação do retorno da requisição")
    @Description("Deve trazer a atividade correspondente ao ID pesquisado")
    @Severity(NORMAL)
    @Category(Funcionality.class)
    public void deveTrazerAtividadeCorrespondenteAoId() {

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

        /**
         * EXEMPLO DE UM VALOR MUTÁVEL PORÉM ESSENCIAL, EM NÃO CONSEGUINDO VALIDAR O RETORNO ESPERADO PODE-SE
         * VALIDAR SE ELE NÃO É NULO E NEM VAZIO
         */

    }

}
