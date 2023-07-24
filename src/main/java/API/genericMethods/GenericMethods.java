package API.genericMethods;

import API.commonFunctions.API_Server;
import API.enums.EndPoints;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GenericMethods {

    public static <T> T restPostWithHeaders(EndPoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .baseUri(API_Server.getReqRes_BaseUri())
                .body(bodyData)
                .when()
                .post(endpoint.getValue())
                .then()
                .extract()
                .as(responseClass);
    }
    public static <T> T restPost(EndPoints endpoint, Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(API_Server.getReqRes_BaseUri())
                .body(bodyData)
                .when()
                .post(endpoint.getValue())
                .then()
                .extract()
                .as(responseClass);
    }

    public static <T> T restPut(EndPoints endpoint, Object bodyData, Map<String, String> headers, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .baseUri(API_Server.getReqRes_BaseUri())
                .headers(headers)
                .body(bodyData)
                .when()
                .put(endpoint.getValue())
                .then()
                .extract()
                .as(responseClass);
    }
    public static <T> T restPostWithAuth(EndPoints endpoint, EndPoints authUsername, EndPoints authPassword, Map<String, String> headers, String bodyData, Class<T> responseClass) {
        return given()
                .auth().basic(authUsername.getValue(),authPassword.getValue())
                .relaxedHTTPSValidation()
                .headers(headers)
                .baseUri(API_Server.urbanAirShipBaseURI)
                .body(bodyData)
                .when()
                .post(endpoint.getValue())
                .then()
                .log().all()
                .extract()
                .as(responseClass);
    }

    public static <T> T restGetWithParms(EndPoints endpoint, String key, String value, Map<String, String> headers, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .param(key, value)
                .headers(headers)
                .baseUri(API_Server.getReqRes_BaseUri())
                .when()
                .get(endpoint.getValue())
                .then()
                .log().all()
                .extract()
                .as(responseClass);
    }

    public static Response restGetWithAsResponse(EndPoints endpoint, Map<String, String> headers) {

        return  given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .baseUri(API_Server.getReqRes_BaseUri())
                .when()
                .get(endpoint.getValue())
                .then().extract().response();
    }

    public static Response restGetWithCookie(EndPoints endpoint,String cookie, Map<String, String> headers) {

        return  given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .cookie(cookie)
                .baseUri(API_Server.getReqRes_BaseUri())
                .when()
                .get(endpoint.getValue())
                .then().extract().response();
    }

    public static Response restGet_CMS(String url) {

        return  given()
                .relaxedHTTPSValidation()
                .baseUri(url)
                .when()
                .get()
                .then().extract().response();
    }

}
