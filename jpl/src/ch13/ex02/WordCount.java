package ch13.ex02;

public class WordCount {
	public int count(String targetString,String targetWord) {

		if(targetString == null) {
			return -1;
		}
		if(targetWord == null || targetWord.isEmpty()) {
			return -1;
		}

		if(targetString.isEmpty()) {
			return 0;
		}

		int count  = 0;
		int result = 0;
		int head = 0;
		char headChar = targetWord.charAt(0);
		while(true) {
			result = targetString.indexOf(targetWord,head);
			if(result == -1) {
				break;
			}

			count++;

			head = targetString.indexOf(headChar,result+1);

			if(head == -1) {
				break;
			}
		}

		return count;

	}
}
