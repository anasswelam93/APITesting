import java.util.HashMap;
import java.util.Map;

public class Cookies {
    public static HashMap<String, String> GenericCookies() {
        HashMap<String, String> cookie = new HashMap<>();
        cookie.put("", TestGetUSer.cookieValue);
        return cookie;
    }
}