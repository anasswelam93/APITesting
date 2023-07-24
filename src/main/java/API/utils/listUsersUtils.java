package API.utils;

import API.enums.EndPoints;
import API.genericMethods.Headers;
import API.models.Pojo_Responses.GetListsUserResponse;
import API.genericMethods.GenericMethods;

public class listUsersUtils {
    public static GetListsUserResponse getUser(){
        return  GenericMethods.restGetWithParms(EndPoints.USERS,"page","2", Headers.GenericHeaders(), GetListsUserResponse.class);
    }

    public static GetListsUserResponse getUser_page1(){
        return  GenericMethods.restGetWithParms(EndPoints.USERS,"page","1", Headers.GenericHeaders(), GetListsUserResponse.class);
    }
}
