import API.commonFunctions.API_Server;
import API.enums.EndPoints;
import API.commonFunctions.NonBDD_Design;
import API.models.Pojo_Responses.CMS_Model;
import API.models.Pojo_Responses.GetListsUserResponse;
import API.genericMethods.GenericMethods;
import API.utils.listUsersUtils;
import io.restassured.http.*;
import io.restassured.http.Cookies;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.jayway.jsonpath.JsonPath.read;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TestGetUSer {
    GetListsUserResponse getUser;
    public static String cookieValue;
     CMS_Model cms;
    @Test
    public void GetUserr_BDD() {

        given().baseUri("https://reqres.in").basePath("/api/users")
                .param("page", "2").headers("Content-Type", "application/json")
                .when().get().then().log().all()

                .assertThat().statusCode(200)
                .assertThat().body("data[0].last_name", is(equalTo("Anas")))
                .assertThat().body("data.last_name", is(hasItem("Funke")))
                .assertThat().body("data.last_name", hasItems("Funke", "Edwards"))
                .assertThat().body("data.last_name", not(hasItem("Anas")))
                .assertThat().body("data.last_name", containsInAnyOrder("Howell", "Lawson", "Ferguson", "Funke", "Fields", "Edwards"))
                .assertThat().body("data.last_name", not(empty()))
                .assertThat().body("data[0]", hasKey("id"))
                .assertThat().body("", hasKey("page"))
                .assertThat().body("", hasValue(2))
                .assertThat().body("", hasEntry("total", 12));
    }

    @Test
    public void GetUser_extractResponse() {

        Response response = given().baseUri("https://reqres.in")
                .param("page", "2")
                .when().get("/api/users").then().extract().response();

        String name = response.path("data[0].last_name");
        Assert.assertEquals(name, "Lawson");


    }

    @Test
    public void GetUser_ResponseByGPath2() {

        Response response = given().baseUri("https://reqres.in")
                .param("page", "2")
                .when().get("/api/users").then().extract().response();
        JsonPath json = new JsonPath(response.asString());
        String value = json.get("data[0].last_name");
        Assert.assertEquals(value, "Lawson");

    }

    @Test
    public void GetUser_useJPath() {

        Response response = given().baseUri("https://reqres.in")
                .param("page", "2")
                .when().get("/api/users");
        Assert.assertEquals(response.statusCode(), 200);
        response.prettyPrint();
        String res = response.asString();
        String name = read(res, "$.data[0].first_name"); //jayway
        List<String> emails = read(res, "$.data[*].email");
        Assert.assertEquals(name, "Michael");
        Assert.assertTrue(emails.contains("michael.lawson@reqres.in"));
    }

    @Test
    public void GetUser_SchemaValidator() {
        NonBDD_Design req = new NonBDD_Design(API_Server.getReqRes_BaseUri(), API_Server.ReqRes_BasePath);
        req.addParmaters("page", "2");
        req.addHeaders("content-type", String.valueOf(ContentType.JSON));
        req.logsOfRequest();
        Response response = req.Response(Method.GET);
        response.prettyPrint();
        response.then().
                body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir") + "/src/main/resources/schema.json")));
    }

    @Test
    public void GetUser_withNonBDD_STD() {
        API_Server.getReqRes_BaseUri();
        NonBDD_Design req = new NonBDD_Design(API_Server.getReqRes_BaseUri(), API_Server.ReqRes_BasePath);
        req.addParmaters("page", "2");
        Response response = req.Response(Method.GET);
        response.prettyPrint();
        getUser = response.as(GetListsUserResponse.class);
        Assert.assertEquals(getUser.page, 2);
        Assert.assertEquals(response.statusCode(), 200);
        for (int i = 0; i < getUser.data.size(); i++) {
            if (getUser.data.get(i).first_name.equalsIgnoreCase("Tobias")) {
                System.out.println(getUser.data.get(i).id);
            }
        }
    }

    @Test
    public void getCookies() {

        Response response = given().baseUri("https://www.google.com.eg")
                .headers("Content-Type", "application/json")
                .when().get();
        String value = response.getCookie("AEC");
        Cookies cookies = response.detailedCookies();
        System.out.println(cookies);
        System.out.println(cookies.getValue("AEC"));
        System.out.println(value); //change every time to run so if we add it in the request so request will be failed

        Map<String, String> cookies1 = response.getCookies();
        for (String key : cookies1.keySet()) {
            String valuee = response.getCookie(key);
            System.out.println(key + "         " + valuee);
        }
    }

    @Test
    public void getHeaders() {

        Response response = given().baseUri("https://www.google.com.eg")
                .headers("Content-Type", "text/html")
                .log().all().when().get();
        System.out.println(response.getHeader("Content-Type"));
        io.restassured.http.Headers headers = response.getHeaders();
        for (Header hd : headers) {
            String name = hd.getName();
            String value = hd.getValue();
            System.out.println(name + "            " + value);
        }
        System.out.println("******************************");
        Map<String, String> cookies1 = response.getCookies();
        for ( String cookieKey : cookies1.keySet()) {
            cookieValue = response.getCookie(cookieKey);
            System.out.println(cookieKey + "         " + cookieValue);
        }

    }

    @Test
    public void test2() {
        Response res = GenericMethods.restGetWithAsResponse(EndPoints.USERS, API.genericMethods.Headers.GenericHeaders());
        Headers headers = res.getHeaders();
        for (Header hd : headers) {
            System.out.println(hd.getName() + "          " + hd.getValue());
        }
        System.out.println("******************************");
        Map<String, String> cookies1 = res.getCookies();
        for ( String cookieKey : cookies1.keySet()) {
             cookieValue = res.getCookie(cookieKey);
            System.out.println(cookieKey + "         " + cookieValue);
        }
    }

    @Test
    public void test() {
        getUser = listUsersUtils.getUser();
        Assert.assertEquals(getUser.page, 2);
        System.out.println(getUser.data.size());
        System.out.println(getUser.data.get(1).first_name);
    }

    @Test
    public void test3() {
        getUser = listUsersUtils.getUser_page1();
        Assert.assertEquals(getUser.page, 1);
        System.out.println(getUser.data.size());
        System.out.println(getUser.data.get(1).first_name);
    }
}