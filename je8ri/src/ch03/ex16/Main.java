package ch03.ex16;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{

		String input = "1";

		ExceptionWrapper.doInOrderAsync(
				() -> {
					return Integer.parseInt(input);
				},
				(v,e) -> {
					if(e == null) {
						//processing if input variable is a number.
					} else {
						//processing other case.
					}
				});
	}

}
