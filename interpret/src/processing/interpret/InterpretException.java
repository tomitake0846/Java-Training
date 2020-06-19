package processing.interpret;

public class InterpretException extends Exception{
	private Throwable e;
	private String message;
	public InterpretException(String message,Throwable throwable) {
		this.message = message;
		this.e = throwable;
	}
	public String getMessage() {
		return this.message;
	}

	public Throwable getException() {
		return this.e;
	}
}
