package dc3_4.model.HttpRequest;

public class RequestFactory {
	public HTTPMethod getInstance(Request name) {
		switch (name) {
		case GET : return new GET();
		case POST :return new POST();
		case PUT :return new PUT();
		default : new UnsupportedOperationException();
		}
		return null;
	}
}
