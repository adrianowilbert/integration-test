package integrationTests.utils;

import java.util.Locale;

import com.github.javafaker.Faker;

public class Utils {

    public static String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
            + "/src/test/java/integrationTests/tests/serveRest/"
            + pack
            + "/contracts/"
            + contract
            + ".json";

    }

    public static final Faker faker = new Faker(new Locale("pt-BR"));

}
