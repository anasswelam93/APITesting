package API.utils;

import API.commonFunctions.API_Server;
import API.genericMethods.GenericMethods;
import io.restassured.response.Response;

public class CMS_utils {
    public static Response getCMS(){
        return GenericMethods.restGet_CMS(API_Server.CMS_DevBaseUri);
    }
}
