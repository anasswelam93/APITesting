package API.objects;

import API.commonFunctions.CommonMethods;
import API.models.Pojo_Requests.UrbanAirshipResponseRequest;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Arrays;

public class UrbanAirshipResponseObject {

    public static String pushNotification(String title) throws JsonProcessingException {
        UrbanAirshipResponseRequest reqBody = new UrbanAirshipResponseRequest();
        reqBody.audience = "all";
        String[] arr = {"ios", "android"};
        reqBody.device_types = Arrays.asList(arr);
        UrbanAirshipResponseRequest.Message msg = new UrbanAirshipResponseRequest.Message();
        msg.title = title;
        msg.body = "bodyyy";
        msg.content_type = "text/html";
        UrbanAirshipResponseRequest.Extra extra = new UrbanAirshipResponseRequest.Extra();
        extra.category="{\"id\": \"4\", \"name\": \"Messages\"}";
        extra.icon="ic3G";
        extra.actionText1="Upgrade";
        extra.action1= "exUrl:https://www.vodafone.com/content/index.html";
        extra.actionText2= "Settings";
        extra.action2= "app:Settings";
        extra.body="Bodyyyyyyyy";
        extra.image=
                "https://file.kelleybluebookimages.com/kbb/base/house/2008/2008-BMW-3%20Series-FrontSide_BM328ICP081_505x375.jpg";
        msg.extra=extra;
        UrbanAirshipResponseRequest.Notification notification= new UrbanAirshipResponseRequest.Notification();
        notification.alert="titlePN";
        reqBody.notification=notification;
        reqBody.message=msg;
        return CommonMethods.convertObjToString(reqBody);
    }

        public static String pushNotification(String title, String body) throws JsonProcessingException {
            UrbanAirshipResponseRequest reqBody = new UrbanAirshipResponseRequest();
            reqBody.audience = "all";
            String[] arr = {"ios", "android"};
            reqBody.device_types = Arrays.asList(arr);
            UrbanAirshipResponseRequest.Message msg = new UrbanAirshipResponseRequest.Message();
            msg.title = title;
            msg.body = body;
            msg.content_type = "text/html";
            UrbanAirshipResponseRequest.Extra extra = new UrbanAirshipResponseRequest.Extra();
            extra.category="{\"id\": \"4\", \"name\": \"Messages\"}";
            extra.icon="ic3G";
            extra.actionText1="Upgrade";
            extra.action1= "exUrl:https://www.vodafone.com/content/index.html";
            extra.actionText2= "Settings";
            extra.action2= "app:Settings";
            extra.body="Bodyyyyyyyy";
            extra.image=
                    "https://file.kelleybluebookimages.com/kbb/base/house/2008/2008-BMW-3%20Series-FrontSide_BM328ICP081_505x375.jpg";
            msg.extra=extra;
            UrbanAirshipResponseRequest.Notification notification= new UrbanAirshipResponseRequest.Notification();
            notification.alert="titlePN";
            reqBody.notification=notification;
            reqBody.message=msg;
            return CommonMethods.convertObjToString(reqBody);
        }

    public static String pushNotification() throws JsonProcessingException {
        UrbanAirshipResponseRequest reqBody = new UrbanAirshipResponseRequest();
        reqBody.audience = "all";
        String[] arr = {"ios", "android"};
        reqBody.device_types = Arrays.asList(arr);
        UrbanAirshipResponseRequest.Notification notification= new UrbanAirshipResponseRequest.Notification();
        notification.alert="titlePN";
        reqBody.notification=notification;

        return CommonMethods.convertObjToString(reqBody);
    }
}
