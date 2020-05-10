package ch24.ex01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {
	public static void main(String[] args) {
		display(Locale.getDefault());
		display(new Locale("en","US"));
		display(new Locale("en","AU"));
	}
	public static void display(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle("ch24//ex01//locale//MyResources", locale);
		System.out.println(bundle.getString(GlobalRes.HELLO));
		System.out.println(bundle.getString(GlobalRes.GOODBYE));
	}
}
