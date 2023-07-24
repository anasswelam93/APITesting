package API.commonFunctions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonMethods {

    public static String convertObjToString (Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return
                mapper.writeValueAsString(obj);
    }
}
