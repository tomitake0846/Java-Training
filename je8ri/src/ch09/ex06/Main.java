package ch09.ex06;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String in = "src/ch09/ex06/test";
		String out = "src/ch09/ex06/test2";

		try {
			FileLoader.readLine(in).stream()
			.map(s -> s.getBytes())
			.map(FileLoader::reverse)
			.map(b -> FileLoader.concat(b, new byte[]{'\r'}))
			.reduce((oldVal,newVal) -> FileLoader.concat(oldVal, newVal))
			.ifPresent(b -> {
				try {
					FileLoader.write(b, out);
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
