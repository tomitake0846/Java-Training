package ch22.ex12;

import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class AttributeReader {
	public static Attributed readAttrs(Reader resource) throws IOException {
		Scanner in = new Scanner(resource);
		AttributedImpl attrs = new AttributedImpl();
		Attr<String> attr = null;

		/*
		 * group(1) ... key (must)
		 * group(2) ... value (must)
		 * group(3) ... comment　(any)
		 * */
		String exp = "([^#]*)=([^#]*)(#.*)*";

		Pattern p = Pattern.compile(exp, Pattern.MULTILINE);

		while(in.hasNextLine()) {
			String line = in.findInLine(p);

			if(line != null) {
				MatchResult m = in.match();
				String key = m.group(1);
				String value = m.group(2);

				attr = new Attr<String>(key,value);
				attrs.add(attr);
			}

			if(in.hasNextLine()) {
				in.nextLine();
			} else {
				break;
			}
		}

		IOException e = in.ioException();
		in.close();
		if(e != null) {
			throw e;
		}

		return attrs;
	}

}
