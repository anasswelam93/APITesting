package API.commonFunctions;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NonBDD_Design {
    public RequestSpecification req;
    public String uri, endPoint;

    public NonBDD_Design(String uri, String endPoint) {
        this.uri = uri;
        this.endPoint = endPoint;
        req = RestAssured.given().baseUri(uri).basePath(endPoint).when();
    }


    public Response Response(Method method) {
        return
                //       request.get();
                req.request(method);
    }

    public <T> T getResponseAsClass(Method method, Class<T> responseClass){
      return
              req.request(method).as(responseClass);
    }


    public void addParmaters(String key, String value) {
        req.param(key, value);
    }

    public void addHeaders(String key, String value) {
        req.header(key, value);
    }

    public void logsOfRequest() {
        req.log().all();
    }

    public void addRequestBody(Object body) {
        req.body(body);
    }

    public void addAuthenticationCredentials(String key, String value) {
        req.auth()
                .basic(key, value);
    }

}
