package ch01.ex16;

import java.io.IOException;

public class BadDataSetException extends Exception{
	String fileName;
	IOException ioe;
	public BadDataSetException() {	}
	public BadDataSetException(String fileName , IOException ioe) {
		this.fileName = fileName;
		this.ioe = ioe;
	}

	public void setIOException(IOException e) {
		this.ioe = e;
	}
	public IOException getIOException() {
		return this.ioe;
	}
	public String getExceptionalFileName() {
		return this.fileName;
	}
}
