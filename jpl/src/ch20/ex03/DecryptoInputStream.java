package ch20.ex03;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class DecryptoInputStream extends FilterReader{
	public DecryptoInputStream(Reader in) {
		super(in);
	}

	public int Decrypto(int key) throws IOException {
		int c = super.read();
		if(c == -1) {
			return -1;
		} else {
			return c - key;
		}
	}
}
