package ch08.ex06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class Point2DTest {

	@Test
	void sortTest1() {
		List<Point2D> list = new ArrayList<>();
		list.add(new Point2D(1,1));
		list.add(new Point2D(3,3));
		list.add(new Point2D(2,2));

		Collections.sort(list,Point2D.compare());

		assertEquals(1,list.get(0).getX());
		assertEquals(2,list.get(1).getX());
		assertEquals(3,list.get(2).getX());
	}

	@Test
	void sortTest2() {
		List<Point2D> list = new ArrayList<>();
		list.add(new Point2D(2,4));
		list.add(new Point2D(1,5));
		list.add(new Point2D(2,3));

		Collections.sort(list,Point2D.compare());


		assertEquals(1,list.get(0).getX());
		assertEquals(5,list.get(0).getY());

		assertEquals(2,list.get(1).getX());
		assertEquals(3,list.get(1).getY());

		assertEquals(2,list.get(2).getX());
		assertEquals(4,list.get(2).getY());
	}

	@Test
	void sortTest3() {
		List<Point2D> list = new ArrayList<>();
		list.add(new Point2D(3,3));
		list.add(new Point2D(1,5));
		list.add(new Point2D(3,4));
		list.add(new Point2D(3,3));

		Collections.sort(list,Point2D.compare());


		assertEquals(1,list.get(0).getX());
		assertEquals(5,list.get(0).getY());

		assertEquals(3,list.get(1).getX());
		assertEquals(3,list.get(1).getY());

		assertEquals(3,list.get(2).getX());
		assertEquals(3,list.get(2).getY());

		assertEquals(3,list.get(3).getX());
		assertEquals(4,list.get(3).getY());
	}

}
