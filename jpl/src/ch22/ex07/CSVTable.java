package ch22.ex07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class CSVTable {

	public static List<String[]> readCSVTable(Readable source,final int CELLS) throws IOException{
		Scanner in = new Scanner(source);
		List<String[]> val = new ArrayList<String[]>();

		String exp = getExp(CELLS);
		Pattern p = Pattern.compile(exp,Pattern.MULTILINE);

		while(in.hasNextLine()) {
			String line = in.findInLine(p);
			if(line != null) {
				String[] cells = new String[CELLS];
				MatchResult m = in.match();
				for(int i = 0;i < CELLS; i++) {
					cells[i] = m.group(i+1);
				}
				val.add(cells);

				if(in.hasNextLine()) {
					in.nextLine();
				} else {
					break;
				}
			} else {
				in.close();
				throw new IOException("input format error");
			}
		}

		IOException e = in.ioException();
		in.close();
		if(e != null) {
			throw e;
		}
		return val;
	}

	private static String getExp(int CELLS) {
		StringBuilder sb = new StringBuilder("^(.*)");

		int i=1;
		while(i < CELLS) {
			sb.append(",(.*)");
			i++;
		}
		sb.append("$");
		return sb.toString();
	}
}
