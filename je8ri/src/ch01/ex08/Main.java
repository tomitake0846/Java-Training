package ch01.ex08;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String[] names = { "Peter","Pail","Mary" };

		run01(names,new ArrayList<Runnable>());
		run02(names,new ArrayList<Runnable>());//fatal error

	}

	public static void run01(String[] names , List<Runnable> runners) {
		for(String name : names) {
			runners.add( () -> System.out.println(name) );
		}
		for(Runnable r : runners) {
			r.run();
		}
	}
	public static void run02(String[] names , List<Runnable> runners) {
		for(int i=0;i<names.length;i++) {
			//Local variable i defined in an enclosing scope must be final or effectively final
//			runners.add( () -> System.out.println(names[i]));

			//Once, it needs to use local variable.
			String name = names[i];
			runners.add( () -> System.out.println(name));
		}
	}
}
