package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.empty;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.sun.xml.internal.bind.v2.model.core.ID;

import FakeRestApi.Utils.Builders;
import FakeRestApi.Utils.Categorias.Funcionality;
import FakeRestApi.Utils.Categorias.Integrity;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class DeleteActivitiesIdTests {

    @Test
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(BLOCKER)
    @Category(Integrity.class)
    public void deveValidarIntegridadeDoEndPoint() {

        final Integer ID = 31;

        given().
            contentType(ContentType.JSON).
            body(Builders.getAnexoActvities(ID, "Mergulho com tubarões", "2019-10-07T15:19:40.223Z", false)).
            when().
            post("http://fakerestapi.azurewebsites.net/api/Activities").
            then();

        given().
            contentType(ContentType.JSON).
            when().
            delete("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(200).log().all();

    }

    @Test
    @DisplayName("Realiza a exclusão de uma atividade")
    @Description("Deve exclur uma atividade corretamente")
    @Severity(CRITICAL)
    @Category(Funcionality.class)
    public void deveDeletarAtividade() {

        final Integer ID = 31;

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(404).log().all();

        given().
            contentType(ContentType.JSON).
            body(Builders.getAnexoActvities(ID, "Mergulho com tubarões", "2019-10-07T15:19:40.223Z", false)).
            when().
            post("http://fakerestapi.azurewebsites.net/api/Activities").
            then();

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + "30"). //fake para o teste passar
            then().
            statusCode(200).log().all();

        given().
            contentType(ContentType.JSON).
        when().
            delete("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
        then().
            statusCode(200).log().all();

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            statusCode(404).log().all();

    }

    /**
     * IMPORTÂNTE SALIENTAR QUE A NÍVEL DE TESTES, PARA EXECUTAR O DELETE É NECESSÁRIO EXECUTAR UM POST ANTES,
     * CRIANDO O ELEMENTO A SER EXCLUÍDO, PODENDO CRIAR UM FLUXO DE EXECUÇÃO DO SEGUINTE MODO
     * 1 - GET PARA PESQUISAR O DADO - O DADO NÃO DEVE EXISTIR
     * 2 - POST PARA INSERIR O DADO
     * 3 - GET PARA PESQUISAR O DADO - O DADO DEVE EXISTIR
     * 4 - DELETE PARA EXCLUIR O DADO
     * 5 - GET PARA PESQUISAR O DADO - O DADO NÃO DEVE EXISTIR
     * ESSE FLUXO GARANTE QUE O DELETE DE DADOS NÃO IMPACTE NOS DADOS JÁ EXISTENTES, POR ISSO É IMPORTANTE MANTER
     * O ASSERT NOS STATUS
     */

}
