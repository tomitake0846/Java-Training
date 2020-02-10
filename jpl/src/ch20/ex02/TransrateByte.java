package ch20.ex02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class TransrateByte extends FilterReader{

	public TransrateByte(Reader in) {
		super(in);
	}

	public int read(char from,char to) throws IOException {
		int dummy = super.read();
		return dummy == from ? to : dummy;
	}
}
