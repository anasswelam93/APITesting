import API.utils.UpdateUserUtils;
import API.enums.EndPoints;
import API.models.Pojo_Responses.PutUserresponse;
import API.objects.PutUserObject;
import API.genericMethods.Headers;
import API.genericMethods.GenericMethods;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPutUser {
    PutUserresponse putUserresponse;
    @Test
    public void test1() throws JsonProcessingException {
    Response res=  given().body(PutUserObject.putUser()).header("content-type", "Application/json").when().put("https://reqres.in/api/users/2")
                .then().log().all().extract().response();
        putUserresponse = res.as(PutUserresponse.class);
        System.out.println(putUserresponse.updatedAt);
        System.out.println(putUserresponse.name);

    }



    @Test
    public void test2() throws JsonProcessingException {
        putUserresponse= GenericMethods.restPut(EndPoints.KEY, PutUserObject.putUser(),Headers.GenericHeaders(),PutUserresponse.class);
        System.out.println(putUserresponse.name);

    }

    @Test
    public void test3() throws JsonProcessingException {
        putUserresponse= UpdateUserUtils.putUserresponse();
        System.out.println(putUserresponse.name);

    }
}
