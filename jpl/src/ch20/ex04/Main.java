package ch20.ex04;

import java.io.IOException;
import java.io.StringReader;

public class Main {
	public static void main(String[] args) {
		test(new StringReader("test"));
		StringReader sr = new StringReader("test1\ntest2\ntest3");

		try (FilterReaderLine frl = new FilterReaderLine(sr);){
			System.out.println(frl.readLine().toString());
			System.out.println(frl.readLine().toString());
			System.out.println(frl.readLine().toString());

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public static void test(StringReader src) {

		try (FilterReaderLine frl = new FilterReaderLine(src);){
			System.out.println(frl.readLine().toString());

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
