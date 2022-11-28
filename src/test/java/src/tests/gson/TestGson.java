package src.tests.gson;

import com.google.gson.Gson;
import src.test_data.models.LoginCred;
import src.test_data.utils.DataObjectBuilder;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TestGson {

    public static void main(String[] args) {
        //Gson gson = new Gson();
        // From Json to Object
        String fileLocation = "/src/test/java/src/tests/gson/login.json";
        //LoginCred[] loginCreds = DataObjectBuilder.buildDataObject(fileLocation, LoginCred[].class);
        //System.out.println(loginCred);

        List<LoginCred> loginCreds = Arrays.asList(DataObjectBuilder.buildDataObject(fileLocation, LoginCred[].class));

        for (LoginCred loginCred : loginCreds) {
            System.out.println(loginCred);
        }


        // From Object to Json
//        LoginCred loginCred1 = new LoginCred("Ti", "87654321");
//        System.out.println(gson.toJson(loginCred1));

    }
}
