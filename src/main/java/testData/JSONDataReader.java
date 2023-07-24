package testData;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class JSONDataReader {
    public Properties prop = null;
    public JSONDataReader postUserData;

    public Properties readProbFile(String filePath) {

        prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream(filePath);
            prop.load(input);

        } catch (Exception e) {
            e.printStackTrace();

            // TODO: handle exception
        } finally {

            if (input != null) {
                try {
                    input.close();

                } catch (Exception e2) {
                    // TODO: handle exception
                    e2.printStackTrace();
                }
            }
        }

        return prop;

    }
}
