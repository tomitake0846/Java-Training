package ch13.ex04;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Transrater {
	public List run(String input) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		String[] lines = input.split("\n");
		List result = new ArrayList();
		for(String line : lines) {
			String[] dummy = line.split(" ");
			result.add(Class.forName("java.lang."+dummy[0])
			.getConstructor(dummy[1].getClass())
			.newInstance(dummy[1]));
		}

		return result;
	}

	public static void main(String[] args) {
		Transrater t = new Transrater();
		try {
			List list = t.run("Integer 1\nInteger 4\nString test\nFloat 3.14\nDouble 3.14");

			for(int i=0;i<list.size();i++) {
				System.out.println(list.get(i));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
