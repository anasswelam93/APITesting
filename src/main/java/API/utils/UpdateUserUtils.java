package API.utils;

import API.enums.EndPoints;
import API.genericMethods.GenericMethods;
import API.genericMethods.Headers;
import API.models.Pojo_Responses.PutUserresponse;
import API.objects.PutUserObject;
import com.fasterxml.jackson.core.JsonProcessingException;

public class UpdateUserUtils {


    public static PutUserresponse putUserresponse () throws JsonProcessingException {
        return  GenericMethods.restPut(EndPoints.KEY, PutUserObject.putUser(), Headers.GenericHeaders(), PutUserresponse.class);

    }
}
