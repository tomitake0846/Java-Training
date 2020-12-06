package dc3_1.model;

public class InformationFactory {

	private final static Information timeInstance = new Time();

	public static Information getTimeInstance() {
		return InformationFactory.timeInstance;
	}
}
