package ch06.ex11;

import java.net.PasswordAuthentication;
import java.util.Scanner;

public class Simulator {
	private static final Scanner s = new Scanner(System.in);
	public void run() {
		Repeater.repeat(Simulator::getPasswordAuthentication, (t) -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "secret".equals(String.valueOf(t.getPassword()));
		}).thenAccept(System.out::println);

	}

	private static PasswordAuthentication getPasswordAuthentication() {
		String user = "";
		String pass = "";
		System.out.print("user name:");
		user = s.nextLine();

		System.out.print("pass word:");
		pass = s.nextLine();

		return new PasswordAuthentication(user,pass.toCharArray());
	}
}
