package ch16.ex04;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class ClassContents {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName("java.awt.Window");
			printMember(c.getDeclaredFields());

			printMember(c.getDeclaredConstructors());

			printMember(c.getDeclaredMethods());

		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMember(AnnotatedElement[] mems) {

		for(AnnotatedElement m : mems) {

			for(Annotation annotation : m.getAnnotations()) {
				System.out.println(annotation);
			}
		}
	}
}
