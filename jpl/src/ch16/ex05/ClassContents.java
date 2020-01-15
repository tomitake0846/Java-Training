package ch16.ex05;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

public class ClassContents {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("java.lang.String");

			printMember(c.getDeclaredFields());

			printMember(c.getDeclaredConstructors());

			printMember(c.getDeclaredMethods());

		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMember(Member[] mems) {

		for(Member m : mems) {

			if(m.getDeclaringClass() == Object.class) {
				continue;
			}

			String decl = m.toString();
			System.out.print(" ");
			System.out.print(strip(decl,"java.lang."));
			AnnotatedElement ae = ((AnnotatedElement) m);
			for(Annotation annotation : ae.getAnnotations()) {
				System.out.print(" "+annotation);
			}
			System.out.println();
		}
	}
	private static String strip(String decl , String target) {
		return decl.replace(target,"");
	}
}
