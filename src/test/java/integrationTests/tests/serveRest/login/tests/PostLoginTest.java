package integrationTests.tests.serveRest.login.tests;

import static integrationTests.domain.Domain._200_OK;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;

import org.junit.Test;
import org.junit.experimental.categories.Category;

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

}
