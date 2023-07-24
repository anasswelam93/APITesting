import API.commonFunctions.API_Server;
import API.enums.EndPoints;
import API.commonFunctions.NonBDD_Design;
import API.models.Pojo_Requests.CreateUserRequest;
import API.models.Pojo_Responses.CreateUser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestPostUSer {

    CreateUser create;

    @Test
    public void PostUser() {

        Response response = RestAssured.given().baseUri("https://reqres.in").basePath("/api/users")
                .header("content-type", "Application/json")
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .log().all().when().post();
        response.prettyPrint();
        String responSe = response.asString();
        JsonPath json = new JsonPath(responSe);
        Assert.assertEquals(responSe.contains("job"), true);
        Assert.assertEquals(json.get("job"), "leader");
       Assert.assertTrue(json.get("createdAt").toString().startsWith("2023"));
    }

    @Test
    public void PostUser_StringBody() {
        String bodyReq = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = RestAssured.given().baseUri("https://reqres.in").basePath("/api/users")
                .header("content-type", "Application/json")
                .body(bodyReq).log().all().when().post();
        response.prettyPrint();
        String responSe = response.asString();
        JsonPath json = new JsonPath(responSe);
        Assert.assertEquals(json.get("job"), "leader");
    }

    @Test
    public void PostUser_HashMap() {
        HashMap<String, Object> obj = new HashMap();
        obj.put("name", "Anas");
        obj.put("job", "Engineer");

        NonBDD_Design req = new NonBDD_Design(API_Server.getReqRes_BaseUri(), API_Server.ReqRes_BasePath);
        req.addHeaders("content-type", "Application/json");
        req.addRequestBody(obj);
        req.logsOfRequest();
        Response response = req.Response(Method.POST);
        response.prettyPrint();
        create = response.as(CreateUser.class);
        Assert.assertEquals(create.job, "teacher");
    }

    @Test
    public void PostUser_serialization_deserialization() {
        CreateUserRequest bodyReq = new CreateUserRequest("Anas", "Engineer");
        NonBDD_Design req = new NonBDD_Design(API_Server.getReqRes_BaseUri(), API_Server.ReqRes_BasePath);
        req.addHeaders("content-type", "Application/json");
        req.addRequestBody(bodyReq);
        req.logsOfRequest();
        Response response = req.Response(Method.POST);
        response.prettyPrint();
        create = req.getResponseAsClass(Method.POST,CreateUser.class);
        Assert.assertEquals(create.name, "Anas");
    }

    @Test
    public void PostUser_withEnumClass() {
        CreateUserRequest bodyReq = new CreateUserRequest("Anas", "Engineer");
        NonBDD_Design req = new NonBDD_Design(API_Server.getReqRes_BaseUri(), EndPoints.USERS.getValue());
        req.addHeaders("content-type", "Application/json");
        req.addRequestBody(bodyReq);
        req.logsOfRequest();
        Response response = req.Response(Method.POST);
        response.prettyPrint();

        create = response.as(CreateUser.class);
        Assert.assertEquals(create.name, "Anas");
    }

    @Test
    public void PostUserrrrr() {

        Response response = RestAssured.given().baseUri("https://www.vodafone.de").basePath("/mint/rest/session/start")
                .header("content-type", "Application/json")
                .body("{\n" +
                        "    \"userName\": \"01621377344\",\n" +
                        "    \"password\": \"vodafone15\"\n" +
                        "}")
                .log().all().when().post();
    }


}
