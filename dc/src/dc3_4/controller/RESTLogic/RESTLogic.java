package dc3_4.controller.RESTLogic;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import dc3_4.model.REST.RESTResources;
import dc3_4.model.REST.ResourceAccess;
import dc3_4.model.config.UserConfig;

public class RESTLogic {
	public static void login(String userID,String password,
			Consumer<String> whenFailed,Consumer<String> whenSuccess) {
		if(userID == null || userID.isEmpty()) {
			whenFailed.accept("user id is empty.");
			return;
		} else if(password == null || password.isEmpty()) {
			whenFailed.accept("password is empty.");
			return;
		}

		Map<String,String> map = new HashMap<String,String>();
		map.put("user-id", userID);
		map.put("password", password);
		try {
			Map<String,String> result = ResourceAccess.connect(RESTResources.login, map);
			String statusCode = result.get("statusCode");
			if(statusCode.equals("200")) {
				whenSuccess.accept(userID);
			} else {
				whenFailed.accept(result.get("body"));
			}

		} catch (IOException e) {
			whenFailed.accept(e.getMessage());
			e.printStackTrace();
		}
	}

	public static void config(String userID,
			Consumer<String> whenFailed,Runnable whenSuccess) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("user-id", userID);
		try {
			Map<String,String> result = ResourceAccess.connect(RESTResources.config, map);

			UserConfig.getInstance().loadFromJson(result.get("body"));
			whenSuccess.run();

			//transform to DC Diaplay!
		} catch (IOException e) {
			whenFailed.accept(e.getMessage());
		}
	}

	public static void regist(String userID,String password,String confirmPassword,
			Consumer<String> whenFailed,Consumer<String> whenSuccess) {
		if(userID == null || userID.isEmpty()) {
			whenFailed.accept("user id is empty.");
			return;
		} else if(password == null || password.isEmpty()) {
			whenFailed.accept("password is empty.");
			return;
		} else if(!password.equals(confirmPassword)) {
			whenFailed.accept("not matched password and confirm password.");
			return;
		}

		try {
			Map<String,String> map = new HashMap<String,String>();
			map.put("user-id", userID);
			map.put("password", password);

			UserConfig config = UserConfig.getInstance();
			config.reflesh();//set default config
			map.put("config", config.toJson());

			Map<String,String> result = ResourceAccess.connect(RESTResources.regist, map);

			if(result.get("statusCode").equals("201")) {
				whenSuccess.accept(config.toJson());
			} else {
				whenFailed.accept(result.get("body"));
			}

		} catch (IOException e) {
			whenFailed.accept(e.getMessage());
		}

	}
}
