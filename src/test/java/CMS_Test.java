import API.commonFunctions.API_Server;
import API.models.Pojo_Responses.CMS_Model;
import API.genericMethods.GenericMethods;
import API.utils.CMS_utils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CMS_Test {

    CMS_Model cms;

    @Test
    public void testCMS() {
        Response resp = given().baseUri(API_Server.CMS_DevBaseUri)
                .when().get();
        cms = resp.as(CMS_Model.class);
        System.out.println(cms.app_name);
        Assert.assertEquals(cms.app_name, "MeinVodafone");
        Assert.assertEquals(cms.login_title_text, "Anas");
    }

    @Test
    public void testCMS_3() {
        Response resp= GenericMethods.restGet_CMS(API_Server.CMS_DevBaseUri);
        cms = resp.as(CMS_Model.class);
        Assert.assertEquals(cms.login_title_text, "MeinVodafone");
        Assert.assertEquals(cms.login_title_text, "Anas");
    }

    @Test
    public void testCMS_2() {
        Response resp= CMS_utils.getCMS();
        cms = resp.as(CMS_Model.class);
        Assert.assertEquals(cms.app_name, "MeinVodafone");
        Assert.assertEquals(cms.login_title_text, "Anas");
    }

}
