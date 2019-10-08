package FakeRestApi.Activities;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.sun.deploy.uitoolkit.impl.fx.Utils;
import com.sun.xml.internal.bind.v2.model.core.ID;

import FakeRestApi.Utils.Builders;
import FakeRestApi.Utils.Categorias.Funcionality;
import FakeRestApi.Utils.Categorias.Integrity;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.http.ContentType;

public class PostActivitiesTests {

    @Test
    @DisplayName("Realiza a validação se o endpoint está respondendo corretamente")
    @Description("Deve validar que o endpoint está funcionando")
    @Severity(BLOCKER)
    @Category(Integrity.class)
    public void deveValidarIntegridadeDoEndPoint() {

        final Integer ID = 31;

        given( ).
            contentType(ContentType.JSON).
            body(Builders.getAnexoActvities(
                ID,
                "Mergulho com Tubarões",
                "2019-10-07T15:19:40.223Z",
                false)).
            when( ).
            post("http://fakerestapi.azurewebsites.net/api/Activities").
            then( ).
            statusCode(200).log( ).all( );
    }

    @Test
    @DisplayName("Realiza a inserção de uma atividade")
    @Description("Deve Inserir uma atividade corretamente")
    @Severity(CRITICAL)
    @Category(Funcionality.class)
    public void deveInserirAtividadeOpção01() {

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
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + ID).
            then().
            body("ID", equalTo(ID)).
            body("Title", equalTo("Mergulho com Tubarões")).
            body("DueDate", is(notNullValue())).
            body("Completed", is(false));

        /**
         * A OPÇÃO 01 SE UTILIZA DE UM CONSTRUTOR QUE ESTÁ ALOCADO DENTRO DE UTILS, NA CLASSE BUILDER
         */

    }

    @Test
    @DisplayName("Realiza a inserção de uma atividade")
    @Description("Deve Inserir uma atividade corretamente")
    @Severity(CRITICAL)
    @Category(Funcionality.class)
    public void deveInserirAtividadeOpção02() {

        String anexoActivities = "{"
            + "\" ID \": \"31\", "
            + "\"Title\": \"Mergulho com Tubarões\", "
            + "\"DueDate\": \"2019-10-07T15:19:40.223Z\", "
            + "\"Completed\": \"true\" }";

        given().
            contentType(ContentType.JSON).
                body(anexoActivities).
            when().
            post("http://fakerestapi.azurewebsites.net/api/Activities").
            then();

        given().
            contentType(ContentType.JSON).
            when().
            get("http://fakerestapi.azurewebsites.net/api/Activities/" + "31").
            then().
            body("ID", equalTo("31")).
            body("Title", equalTo("Mergulho com Tubarões")).
            body("DueDate", is(notNullValue())).
            body("Completed", is(false));

        /**
         * A OPÇÃO 02 SE UTILIZA DE UM JSON ESTRUTURADO COMO STRING, SEM DEPENDÊNCIA DE OUTRAS CLASSES
         */

    }

    /**
     * OBSERVAÇÃO: É POSSÍVEL UTILIZAR DO POST PARA AMPLIAR A MASSA DE DADOS PARA OS TESTES,
     * PORÉM CASO ISSO NÃO SEJA VIÁVEL SERÁ NECESSÁRIO EXECUTAR UM DELETE
     * SEGUIDO DE UM GET PARA VALIDAR SE O DADO FOI EXCLUÍDO
     */

}
