package API.models.Pojo_Requests;

import java.util.List;

public class UrbanAirshipResponseRequest {
    public String audience;
    public Notification notification;
    public List<String> device_types;
    public Message message;

    public static class Extra {
        public String category;
        public String icon;
        public String actionText1;
        public String action1;
        public String actionText2;
        public String action2;
        public String body;
        public String image;
    }

    public static class Message {
        public String title;
        public String body;
        public String content_type;
        public Extra extra;
    }

    public static class Notification {
        public String alert;
    }

}
