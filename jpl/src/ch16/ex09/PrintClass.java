package ch16.ex09;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;

public class PrintClass {
	public PrintClass(String typeName) {

	}

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("java.lang.String");

			System.out.println(strip(c.toGenericString(),"java.lang.")+" {");

			printMember(c.getDeclaredFields());

			printMember(c.getDeclaredConstructors());

			printMember(c.getDeclaredMethods());

			System.out.println("}");

		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMember(Member[] mems) {

		for(Member m : mems) {

			if(m.getDeclaringClass() == Object.class) {
				continue;
			}

			AnnotatedElement ae = ((AnnotatedElement) m);
			if(ae.getAnnotations().length > 0) {
				System.out.print("\n\t");
				for(Annotation annotation : ae.getAnnotations()) {
					System.out.print(annotation+" ");
				}
			}
			System.out.println();
			String decl = m.toString();
			System.out.print("\t");
			System.out.println(strip(decl,"java.lang."));
		}
	}
	private static String strip(String decl , String target) {
		return decl.replace(target,"");
	}
}
