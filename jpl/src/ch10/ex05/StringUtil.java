package ch10.ex05;

public class StringUtil {

	private String target;

	public StringUtil(String target) {
		this.target = target;
	}

	public void printBetweenChars(char firstChar,char lastChar) {
		int indexAtFirst = target.indexOf(firstChar) + 1;
		String dummy = target.substring(indexAtFirst,target.length());
		int indexAtLast = dummy.lastIndexOf(lastChar);
		dummy = dummy.substring(0,indexAtLast);
		System.out.println(dummy);
	}
}
