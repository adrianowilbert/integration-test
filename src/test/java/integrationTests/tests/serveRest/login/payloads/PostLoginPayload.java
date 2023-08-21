package integrationTests.tests.serveRest.login.payloads;

import org.json.simple.JSONObject;

public class PostLoginPayload {

    public static JSONObject postLoginPayload(final String email, final String password) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("email", email);
        jsonObject.put("password", password);

        return jsonObject;
    }

}
