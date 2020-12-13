package ch09.ex05;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String in = "src/ch09/ex05/test";
		String out = "src/ch09/ex05/test2";

		try {
			byte[] bytes = FileLoader.read(in);
			FileLoader.write(FileLoader.reverse(bytes), out);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
