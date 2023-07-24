package API.genericMethods;

import java.util.HashMap;
import java.util.Map;

public class Headers {

    public static HashMap<String, String> GenericHeaders() {
        HashMap<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/json");
        return header;
    }

    public static Map<String, String> urbanAirShipHeaders() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("Content-Type", "application/json");
        params.put("Accept", "application/vnd.urbanairship+json;version=3");
        return params;
    }
}
