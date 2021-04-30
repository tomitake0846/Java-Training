package dc3_4.model.REST;

import java.io.IOException;
import java.util.Map;

import dc3_4.model.HttpRequest.HTTPMethod;
import dc3_4.model.HttpRequest.Request;
import dc3_4.model.HttpRequest.RequestFactory;
import dc3_4.model.utils.JsonProcessor;

public class ResourceAccess {

	private static final String RESOURCE_URI = "https://0fc8fr8puf.execute-api.ap-northeast-1.amazonaws.com/prod/";
	private static final RequestFactory FACTORY = new RequestFactory();

	public static Map<String,String> connect(RESTResources resource,Map<String,String> params) throws IOException {
		HTTPMethod request = resourceToMethod(resource);
		String uri = ResourceAccess.RESOURCE_URI + resource;

		String response = request.exec(uri, params);
		return JsonProcessor.jsonToMap(response);
	}

	private static HTTPMethod resourceToMethod(RESTResources resource) {
		switch(resource) {
		case login: return ResourceAccess.FACTORY.getInstance(Request.POST);
		case update:
		case regist: return ResourceAccess.FACTORY.getInstance(Request.PUT);
		case config: return ResourceAccess.FACTORY.getInstance(Request.GET);
		}
		return null;
	}
}
