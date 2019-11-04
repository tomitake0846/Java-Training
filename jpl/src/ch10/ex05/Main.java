package ch10.ex05;

public class Main {

	public static void main(String[] args) {
		StringUtil util = new StringUtil("<html>");
		//html
		util.printBetweenChars('<', '>');

		util = new StringUtil("<<<html>>>");
		//<<html>>
		util.printBetweenChars('<','>');
	}

}
