package API.models.HashMap_Requests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RequestBody_PN {
	public HashMap<String, Object> sendReqBody(String title, String body) {
		HashMap<String, Object> obj = new HashMap<>();
		obj.put("audience", "all");
		HashMap<String, Object> notification = new HashMap<>();
		notification.put("alert", "titlePN");
		obj.put("notification", notification);
		List<String> deviceypes = new ArrayList<>();
		deviceypes.add("ios");
		deviceypes.add("android");
		obj.put("device_types", deviceypes);
		HashMap<String, Object> message = new HashMap<>();
		message.put("title", title);
		message.put("body", body);
		message.put("content_type", "text/html");
		HashMap<String, Object> extra = new HashMap<>();
		extra.put("category", "{\"id\": \"4\", \"name\": \"Messages\"}");
		extra.put("icon", "ic3G");
		extra.put("actionText1", "Upgrade");
		extra.put("action1", "exUrl:https://www.vodafone.com/content/index.html");
		extra.put("actionText2", "Settings");
		extra.put("action2", "app:Settings");
		extra.put("body", "Bodyyyyyyyy");
		extra.put("image",
				"https://file.kelleybluebookimages.com/kbb/base/house/2008/2008-BMW-3%20Series-FrontSide_BM328ICP081_505x375.jpg");
		message.put("extra", extra);
		obj.put("message", message);
		return obj;
	}
	public HashMap<String, Object> sendReqBody() {
		HashMap<String, Object> obj = new HashMap<>();
		obj.put("audience", "all");
		HashMap<String, Object> notification = new HashMap<>();
		notification.put("alert", "titlePN");
		obj.put("notification", notification);
		List<String> deviceypes = new ArrayList<>();
		deviceypes.add("ios");
		deviceypes.add("android");
		obj.put("device_types", deviceypes);
		return obj;
	}
}

