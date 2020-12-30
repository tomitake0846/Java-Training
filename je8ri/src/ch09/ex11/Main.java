package ch09.ex11;

public class Main {
	public static void main(String[] args) {
		CreditCardStealer ccs = new CreditCardStealer();

		for(String str : ccs.run()) {
			System.out.println(str);
		}
	}
}
