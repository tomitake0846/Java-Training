package ch08.ex06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class Rectangle2DTest {

	@Test
	void sortTest1() {
		List<Rectangle2D> list = new ArrayList<>();
		list.add(new Rectangle2D(2,3));
		list.add(new Rectangle2D(1,2));
		list.add(new Rectangle2D(3,4));

		Collections.sort(list,Rectangle2D.compare());

		assertEquals(2,list.get(0).area());
		assertEquals(6,list.get(1).area());
		assertEquals(12,list.get(2).area());
	}

	@Test
	void sortTest2() {
		List<Rectangle2D> list = new ArrayList<>();
		list.add(new Rectangle2D(2,3));
		list.add(new Rectangle2D(1,2));
		list.add(new Rectangle2D(2,3));
		list.add(new Rectangle2D(3,4));

		Collections.sort(list,Rectangle2D.compare());

		assertEquals(2,list.get(0).area());
		assertEquals(6,list.get(1).area());
		assertEquals(6,list.get(2).area());
		assertEquals(12,list.get(3).area());
	}

	@Test
	void sortTest3() {
		List<Rectangle2D> list = new ArrayList<>();
		list.add(new Rectangle2D(2,3));
		list.add(new Rectangle2D(1,2));
		list.add(new Rectangle2D(3,2));
		list.add(new Rectangle2D(3,4));

		Collections.sort(list,Rectangle2D.compare());

		assertEquals(2,list.get(0).area());
		assertEquals(6,list.get(1).area());
		assertEquals(6,list.get(2).area());
		assertEquals(12,list.get(3).area());
	}

}
