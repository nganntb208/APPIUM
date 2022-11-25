package src.tests.gson;

import com.google.gson.Gson;
import src.test_data.models.LoginCred;

public class TestGson {

    public static void main(String[] args) {
        Gson gson = new Gson();
        // From Json to Object
        String jsonStr = "{\n" +
                "  \"username\" : \"Teo\",\n" +
                "  \"password\" : \"12345678\"\n" +
                "}";

        LoginCred loginCred = gson.fromJson(jsonStr, LoginCred.class);
        System.out.println(loginCred);

        // From Object to Json
        LoginCred loginCred1 = new LoginCred("Ti", "87654321");
        System.out.println(gson.toJson(loginCred1));

    }
}
