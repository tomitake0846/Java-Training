package ch20.ex02;

import java.io.IOException;
import java.io.StringReader;

public class Main2002 {

	public static void main(String[] args) {
		if(args.length != 3) {
			throw new IllegalArgumentException("wrong arguments "+ args.length +".");
		}

		char from = args[0].charAt(0);
		char to = args[1].charAt(0);
		String targetString = args[2];

		StringReader src = new StringReader(targetString);
		TransrateByte f = new TransrateByte(src);

		int c = 0;

		try {
			while((c = f.read(from,to)) != -1) {
				System.out.write((char)c);
			}
			System.out.println();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}

}
