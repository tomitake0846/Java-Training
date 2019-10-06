package dc1_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFactory {
	public static WindowAdapter createCloseButton() {
		return new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
	}
}
