package integrationTests.tests.serveRest.login.tests;

import static integrationTests.domain.Domain._200_OK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.HashMap;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import integrationTests.examples.ReturnExamples;
import integrationTests.suites.AllSuites;
import integrationTests.tests.serveRest.base.BaseSetup;
import integrationTests.tests.serveRest.login.request.PostLoginRequest;
import integrationTests.utils.Utils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import lombok.SneakyThrows;

@Feature("Autentique o seu usuário para montar um carrinho e, se for administrador, gerenciar os produtos")
@Story("A duração do token retornado em authorization é de 600 segundos (10 minutos). "
    + "Caso esteja expirado irá receber status code 401 (Unauthorized).")
@Link("https://serverest.dev/#/Login")
public class PostLoginTest extends BaseSetup {

    PostLoginRequest postLoginRequest = new PostLoginRequest();

    final String email = "adrianowilbert@gmail.com";
    final String password = "server123";

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category({AllSuites.class})
    @DisplayName("Verifica que o contrato do serviço PostLogin está de acordo com o esperado na documentação - Swagger")
    @Description("Deve apresentar contrato correto Quando eu executar o serviço com valores válidos")
    public void deveApresentarContratoCorretoQuandoUtilizadoValoresValidos() {

        postLoginRequest.postLogin(email, password)
            .then()
            .statusCode(_200_OK)
            .body(matchesJsonSchema(new File(Utils
                .getContractsBasePath("login", "PostLoginContract"))));

    }

    @Test
    @SneakyThrows
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verifica que é possível consultar a lista dos números até 10")
    @Description("Deve apresentar sucesso quando validado retorno com lista numérica")
    @Category({AllSuites.class})
    public void deveApresentarSucessoQuandoValidadoRetornoComListaNumerica() {

        //Instancia a classe de examples com uma lista a ser validada no retorno
        final HashMap<Integer, String> numeros = ReturnExamples.returnExamples();

        //Executa a requisição
        postLoginRequest.postLogin(email, password)
            .then()
            .statusCode(_200_OK)
            .extract().jsonPath();

        //Varre a lista
        for (int i = 0; i < numeros.size(); i++) {

            //Guarda os valores de lista para comparação
            int idNumero = Integer.parseInt(("resultado.dos.valores.de.campos.da.lista[" + i + "]"));
            String descricaoNumero = ("resultado.dos.valores.de.campos.da.lista[" + i + "]");

            //Realiza validação da ligação entre chave e valor
            String descricao = numeros.get(idNumero);

            //Printa na tela os valores
            System.out.println("Id do número = " + idNumero);
            System.out.println("Descricao do número= " + descricaoNumero);

            //Realiza a asserção de igualizade entre valores do serviço e valores da lista nos exemplos
            assertEquals(descricao, descricaoNumero);

        }

    }

}
