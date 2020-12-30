package ch08.ex09;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

class ScannerUtilsTest {

	@Test
	void toLineStreamTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/StringTest");
		Scanner s = new Scanner(file);
		List<String> list = ScannerUtils.toLineStream(s).collect(Collectors.toList());

		assertEquals("test test",list.get(0));
		assertEquals("",list.get(1));
		assertEquals("sample",list.get(2));
		assertEquals(3,list.size());

	}

	@Test
	void toWordStreamTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/StringTest");
		Scanner s = new Scanner(file).useDelimiter(" |\n");
		List<String> list = ScannerUtils.toWordStream(s).collect(Collectors.toList());

		assertEquals("test",list.get(0));
		assertEquals("test",list.get(1));
		assertEquals("",list.get(2));
		assertEquals("sample",list.get(3));
		assertEquals(4,list.size());
	}

	@Test
	void toIntStreamTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/IntTest");
		Scanner s = new Scanner(file);
		List<Integer> list = ScannerUtils.toIntStream(s).collect(Collectors.toList());

		assertEquals(2,list.get(0).intValue());
		assertEquals(4,list.get(1).intValue());
		assertEquals(8,list.get(2).intValue());
		assertEquals(3,list.size());
	}

	@Test
	void toIntStreamAnotherTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/IntTest");
		Scanner s = new Scanner(file);
		List<Integer> list = ScannerUtils.toIntStreamAnother(s).collect(Collectors.toList());

		assertEquals(2,list.get(0).intValue());
		assertEquals(4,list.get(1).intValue());
		assertEquals(8,list.get(2).intValue());
		assertEquals(3,list.size());
	}

	@Test
	void toIntStreamExceptionalTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/IllegalIntTest");
		Scanner s = new Scanner(file);

		assertThrows(NumberFormatException.class, () -> ScannerUtils.toIntStream(s).count());
	}

	@Test
	void toIntStreamAnotherExceptionalTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/IllegalIntTest");
		Scanner s = new Scanner(file);
		List<Integer> list = ScannerUtils.toIntStreamAnother(s).collect(Collectors.toList());

		assertEquals(2,list.get(0).intValue());
		assertEquals(8,list.get(1).intValue());
		assertEquals(2,list.size());
	}

	@Test
	void toDoubleStreamTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/DoubleTest");

		Scanner s = new Scanner(file);
		List<Double> list = ScannerUtils.toDoubleStream(s).collect(Collectors.toList());

		assertEquals(1.5,list.get(0).doubleValue(),0.01);
		assertEquals(0.75,list.get(1).doubleValue(),0.001);
		assertEquals(0.375,list.get(2).doubleValue(),0.0001);
		assertEquals(3,list.size());
	}

	@Test
	void toDoubleStreamAnotherTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/DoubleTest");

		Scanner s = new Scanner(file);
		List<Double> list = ScannerUtils.toDoubleStreamAnother(s).collect(Collectors.toList());

		assertEquals(1.5,list.get(0).doubleValue(),0.01);
		assertEquals(0.75,list.get(1).doubleValue(),0.001);
		assertEquals(0.375,list.get(2).doubleValue(),0.0001);
		assertEquals(3,list.size());
	}

	@Test
	void toDoubleStramExceptionalTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/IllegalDoubleTest");
		Scanner s = new Scanner(file);

		assertThrows(NumberFormatException.class, () -> ScannerUtils.toDoubleStream(s).count());

	}

	@Test
	void toDoubleStramAnotherExceptionalTest() throws FileNotFoundException {
		File file = new File("./test/ch08/ex09/IllegalDoubleTest");
		Scanner s = new Scanner(file);

		List<Double> list = ScannerUtils.toDoubleStreamAnother(s).collect(Collectors.toList());

		assertEquals(1.5,list.get(0).doubleValue(),0.01);
		assertEquals(0.375,list.get(1).doubleValue(),0.0001);
		assertEquals(2,list.size());
	}

}
