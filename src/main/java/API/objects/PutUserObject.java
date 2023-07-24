package API.objects;

import API.commonFunctions.CommonMethods;
import API.models.Pojo_Requests.CreateUserRequest;
import API.models.Pojo_Requests.PutUserRequest;
import API.models.Pojo_Requests.UrbanAirshipResponseRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

public class PutUserObject {

    public static String putUser() throws JsonProcessingException {
        PutUserRequest reqBody = new PutUserRequest();
        reqBody.name="Anas";
        reqBody.job="engineer";
        return CommonMethods.convertObjToString(reqBody);
    }
}
