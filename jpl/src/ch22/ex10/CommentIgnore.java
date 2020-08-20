package ch22.ex10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CommentIgnore {
	public static List<String> readWithoutComment(Readable source) throws IOException{
		Scanner in = new Scanner(source);
		List<String> val = new ArrayList<String>();
		String exp = "([^#]*)(#.*)*";

		Pattern p = Pattern.compile(exp,Pattern.MULTILINE);

		while(in.hasNextLine()) {
			String line = in.findInLine(p);
			if(line != null) {
				MatchResult m = in.match();
				val.add(m.group(1));

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
		return val;
	}

}
