package ch20.ex03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class EncryptoOutputStream extends FilterReader{
	public EncryptoOutputStream(Reader in) {
		super(in);
	}
	public int Encrypto(int key) throws IOException{
		int i = super.read();
		if(i == -1) {
			return -1;
		} else {
			return i+key;
		}
	}
}
