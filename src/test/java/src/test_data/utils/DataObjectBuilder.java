package src.test_data.utils;

import src.test_data.models.LoginCred;

import java.io.FileOutputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T builDataObject(String fileLocation, Class<T> dataType) {
        T returnedData;
        String absoluteFilePath = System.getProperty("user.dir").concat(fileLocation);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
                ) {
        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnedData;
    }
}
