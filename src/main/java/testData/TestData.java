package testData;

import com.google.gson.Gson;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestData {
    JSONDataReader postUserData;
    Gson gson = new Gson();

    public Object getPostReqData(String JSON_path) throws IOException, ParseException {
        JSONObject object = (JSONObject) new JSONParser().parse(new FileReader((JSON_path)));
        return gson.fromJson(String.valueOf(object),Object.class);
    }

}
