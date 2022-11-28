package src.test_data.utils;

import com.google.gson.Gson;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class DataObjectBuilder {

    public static <T> T buildDataObject(String fileLocation, Class<T> dataType) {
        T returnedData = null;
        String absoluteFilePath = System.getProperty("user.dir").concat(fileLocation);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath));
                ) {
            Gson gson = new Gson();
            returnedData = gson.fromJson(reader, dataType);
        } catch (NoSuchFileException noSuchFileException) {
            throw new RuntimeException("[ERR] Could not locate the file: ".concat(absoluteFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (returnedData == null) {
            throw new RuntimeException("[ERR] Return data is null!");
        }
        return returnedData;
    }
}
