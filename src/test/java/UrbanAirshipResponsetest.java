import API.commonFunctions.API_Server;
import API.models.HashMap_Requests.RequestBody_PN;
import API.enums.EndPoints;
import API.models.Pojo_Responses.UrbanAirshipResponseResponse;
import API.objects.UrbanAirshipResponseObject;
import API.commonFunctions.NonBDD_Design;
import API.utils.UrbanAirshipUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class UrbanAirshipResponsetest {
    UrbanAirshipResponseResponse urbanAirshipResponseModel;

    @Test
    public void sendPushNotificationForMessageCenter() {
        RequestBody_PN Body = new RequestBody_PN();
        HashMap<String, Object> bodyy = Body.sendReqBody("titleeee", "bodyyyy");

        Response response = RestAssured.given().baseUri(API_Server.urbanAirShipBaseURI).contentType(ContentType.JSON).auth()
                .basic(API_Server.PN_AuthKey, API_Server.PN_AuthValue).body(bodyy).when().post(API_Server.Push_endPoint)
                .then().log().all().contentType(ContentType.JSON).extract().response();
        response.prettyPrint();
    }

    @Test
    public void sendRegularPN() throws IOException {
        String body = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") + "/test.json")));

        NonBDD_Design req = new NonBDD_Design(API_Server.urbanAirShipBaseURI, API_Server.Push_endPoint);
        req.addAuthenticationCredentials(API_Server.PN_AuthKey, API_Server.PN_AuthValue);
        req.addHeaders("content-type", "Application/json");
        req.addRequestBody(body);
        req.logsOfRequest();
        Response response = req.Response(Method.POST);
        response.prettyPrint();
    }

    @Test
    public void sendPushNotificationForMessageCenter_Pojo() throws JsonProcessingException {
        String body = UrbanAirshipResponseObject.pushNotification("Helooo");
        Response response = RestAssured.given().baseUri(API_Server.urbanAirShipBaseURI).contentType(ContentType.JSON).auth()
                .basic(API_Server.PN_AuthKey, API_Server.PN_AuthValue).body(body).when().post(API_Server.Push_endPoint)
                .then().log().all().contentType(ContentType.JSON).extract().response();
        response.prettyPrint();
    }

    @Test
    public void sendRegularPN_Pojo() throws JsonProcessingException {
        String body = UrbanAirshipResponseObject.pushNotification();
        Response response = RestAssured.given().baseUri(API_Server.urbanAirShipBaseURI).contentType(ContentType.JSON).auth()
                .basic(API_Server.PN_AuthKey, API_Server.PN_AuthValue).body(body).when().post(API_Server.Push_endPoint)
                .then().log().all().contentType(ContentType.JSON).extract().response();
        response.prettyPrint();
    }

    @Test
    public void sendRegularPN_Enum() throws JsonProcessingException {
        String body = UrbanAirshipResponseObject.pushNotification();
        Response response = RestAssured.given().baseUri(API_Server.urbanAirShipBaseURI).contentType(ContentType.JSON).auth()
                .basic(EndPoints.PN_AuthKey.getValue(), EndPoints.PN_AuthValue.getValue()).body(body).when().post(EndPoints.PUSH.getValue())
                .then().log().all().contentType(ContentType.JSON).extract().response();
        response.prettyPrint();
    }


    @Test
    public void sendPushNotification() throws JsonProcessingException {
        urbanAirshipResponseModel = UrbanAirshipUtils.getPushNotification();
        Assert.assertEquals(String.valueOf(urbanAirshipResponseModel.ok), "true");

    }
}
