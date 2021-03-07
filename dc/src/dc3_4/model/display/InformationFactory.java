package dc3_4.model.display;

public class InformationFactory {

	private final static Information timeInstance = new Time();

	public static Information getTimeInstance() {
		return InformationFactory.timeInstance;
	}
}
