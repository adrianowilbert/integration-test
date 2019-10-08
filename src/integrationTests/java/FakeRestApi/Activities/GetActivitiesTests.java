package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import FakeRestApi.Utils.Categorias.Funcionality;
import FakeRestApi.Utils.Categorias.Integrity;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class GetActivitiesTests {

    @Test
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(BLOCKER)
    @Category({Integrity.class, Funcionality.class})
    public void devedeValidarIntegridadeDoEndPointTrazendoListaDeAtividade() {

        given().
            contentType(ContentType.JSON).
        when().
            get("http://fakerestapi.azurewebsites.net/api/Activities").
        then().
            statusCode(200).log().all(). //Integrity
            body(not(empty())); //Funcionality

        /**
         * NO MESMO TESTE ESTÁ SENDO VALIDADO A INTEGRIDADE COM O STATUS 200
         * E A FUNCIONALIDADE INFORMANDO QUE O RETORNO NÃO PODE SER VAZIO
         * E NA ANOTATION @Category FORAM INSERIDAS AS DUAS CATEGORIAS
         * TESTES QUE PODEM SER REALIZADOS NESTE ENDPOINT É A QUANTIDADE DE DADOS RETORNADOS
         * E APÓS UM DELETE EXECUTAR NOVAMENTE E VER SE A LISTA DIMINUIU
         */

    }

}
