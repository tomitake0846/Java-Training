package ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FilterReaderLine extends FilterReader{

	protected FilterReaderLine(Reader in) {
		super(in);
	}

	public List<Character> readLine() throws IOException{
		List<Character> list = new ArrayList<Character>();
		int c;
		do {
			c = super.read();
			if(c == -1 || c == 0x0a) break;
			list.add((char)c);
		} while(c != -1);
		return list;
	}

}
