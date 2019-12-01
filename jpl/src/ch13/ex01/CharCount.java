package ch13.ex01;

public class CharCount {
	public int count(String targetString,char targetChar) {
		if(targetString == null) {
			return -1;
		}

		if(targetString.isEmpty()) {
			return 0;
		}

		int count = 0;

		for(char c : targetString.toCharArray()) {
			if (c == targetChar) {
				count ++;
			}
		}

		return count;
	}
}
