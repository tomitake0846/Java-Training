package ch20.ex01;

public class Main {

	public static void main(String[] args) {
		if(args.length != 3) {
			throw new IllegalArgumentException("wrong arguments "+ args.length +".");
		}

		char from = args[0].charAt(0);
		char to = args[1].charAt(0);
		String filePath = args[2];

		TransrateByte tb = new TransrateByte();
		tb.transrate(from, to, filePath);

	}

}
