package processing.interpret;

public class InterpretException extends Exception{
	private Exception e;
	private String message;
	public InterpretException(String message,Exception e) {
		this.message = message;
		this.e = e;
	}
	public String getMessage() {
		return this.message;
	}

	public Exception getException() {
		return this.e;
	}
}
