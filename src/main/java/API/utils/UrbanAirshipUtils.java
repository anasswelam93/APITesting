package API.utils;

import API.enums.EndPoints;
import API.models.Pojo_Responses.UrbanAirshipResponseResponse;
import API.objects.UrbanAirshipResponseObject;
import API.genericMethods.Headers;
import API.genericMethods.GenericMethods;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UrbanAirshipUtils {

    public static UrbanAirshipResponseResponse getPushNotification() throws JsonProcessingException {
        return GenericMethods.restPostWithAuth(EndPoints.PUSH,EndPoints.PN_AuthKey,EndPoints.PN_AuthValue, Headers.urbanAirShipHeaders(),UrbanAirshipResponseObject.pushNotification(), UrbanAirshipResponseResponse.class);
    }
}
