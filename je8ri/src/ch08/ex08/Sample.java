package ch08.ex08;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class Sample {

	public static void main(String[] args) {

	}

	public static void test1() {
		/*
		 * Exception in thread "main" java.lang.ClassCastException:
		 *  Attempt to insert class java.lang.Integer element into collection with element type class java.lang.String
		 * */

		Queue q = Collections.checkedQueue(new ArrayDeque(), String.class);
		q.add(1);
	}

	public static void test2() {
		/*
		 * no Error
		 * */
		Queue q = new ArrayDeque();
		q.add(1);
		q = Collections.checkedQueue(q, String.class);
	}

}
