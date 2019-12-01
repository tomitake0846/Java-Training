package ch13.ex03;

import java.util.ArrayList;
import java.util.List;

public class Delimited {

	public static String[] delimitedString(String from,char start,char end) {
		List<String> result = new ArrayList<String>();

		String dummy;
		int startIndex = 0;
		while((dummy = delimitedString(from,startIndex,start,end))!=null) {

			result.add(dummy);

			if(dummy.indexOf(end) == -1) {
				break;
			}

			startIndex = from.indexOf(end,startIndex) + 1;

			if(start == end) {
				startIndex++;
			}

		}

		return result.toArray(new String[0]);
	}

	public static String delimitedString(String from,int startIndex,char start,char end) {
		int startPos = from.indexOf(start,startIndex);
		if(startPos == -1) {
			return null;
		}

		int endPos = from.indexOf(end,startPos+1);
		if (endPos == -1) {
			return from.substring(startPos);
		}

		//startPos update
		/* use case
		 * from <<HU>GA>
		 * start '<'
		 * end '>'
		 * from.substring(startPos,endPos + 1);//want to "<HU>"
		 * */
		startPos = from.lastIndexOf(start,endPos);

		return from.substring(startPos,endPos + 1);
	}
}
