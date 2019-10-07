package dc1_2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFactory {

	public static WindowAdapter getButton(ButtonType type) {

		switch(type) {
			case CLOSE : return createCloseButton();
			default : throw new IllegalArgumentException();
		}

	}

	private static WindowAdapter createCloseButton() {
		return new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
	}
}
