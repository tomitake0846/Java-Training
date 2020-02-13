package ch20.ex06;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class Attribute {

	private Map<String,Double> map = new HashMap<String,Double>();

	public static void main(String[] args) throws IOException {
		Attribute a = new Attribute();
		File file = new File("C:\\Users\\test\\src\\Java-Training\\jpl\\src\\ch20\\ex06\\test.txt");
		FileReader fr = new FileReader(file);
		a.sumStream(fr);

	}

	public void sumStream(Reader source) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		String target=null;
		int op=0;
		while(in.nextToken() != StreamTokenizer.TT_EOF) {

			//when read name.
			if(in.sval != null) {
				target = in.sval;
				if(!map.containsKey(in.sval)) {
					map.put(in.sval, 0.0);
				}
				continue;
			}

			//when read property
			boolean flag = false;
			switch(in.ttype) {
				case '+' : op = in.ttype;flag = true;break;
				case '-' : op = in.ttype;flag = true;break;
				case '=' : op = in.ttype;flag = true;break;
			}
			if(flag) continue;

			//when read value;
			double dummy = map.get(target);
			switch(op) {
			case '+' : dummy += in.nval;break;
			case '-' : dummy -= in.nval;break;
			case '=' : dummy = in.nval;break;
			}

			map.put(target,dummy);
			dummy=0.0;
			op=0;
			target = null;
		}
		for(String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}
}
