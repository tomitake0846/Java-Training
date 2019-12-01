package ch13.ex06;

public class Comma {
	//...cheat?
	public String transrate(String target,int separationDigit,String separationStr) {

		if(separationDigit <= 0 ) {
			throw new IllegalArgumentException();
		}

		StringBuilder sb = new StringBuilder();
		char[] array = target.toCharArray();
		int index = array.length -1;
		int digit = 0;
		while(index >= 0) {
			//separationStr insert.
			//Here,it insert white space instead of separationStr temporarily.
			//Because if separationStr is two or more characters ,
			//separationStr is affected reverse().
			if(digit == separationDigit) {
				sb.append(" ");
				digit = 0;
			}

			sb.append(array[index]);

			index--;
			digit++;
		}
		sb.reverse();
		return sb.toString().replaceAll(" ",separationStr);
	}
	public static void main(String[] args) {
		Comma c = new Comma();
		System.out.println(c.transrate("123456",1,"hoge"));
	}
}
