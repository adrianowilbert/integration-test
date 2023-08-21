package integrationTests.tests.serveRest.base;

import org.junit.BeforeClass;

import integrationTests.utils.EnvironmentSetting;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

public class BaseSetup {

    @BeforeClass
    public static void setup() {

        RestAssured.baseURI = EnvironmentSetting.getInstance().getBaseUrl();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RequestSpecBuilder contentType = new RequestSpecBuilder();
        contentType.setContentType("application/json");
        RestAssured.requestSpecification = contentType.build();
    }

}
