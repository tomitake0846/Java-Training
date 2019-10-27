package dc1_2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFactory {

	public static WindowAdapter getButton(ButtonType type) {

		switch(type) {
			default : throw new IllegalArgumentException();
		}

	}

	public static WindowAdapter getCloseButton(Close closeItem) {
		return new WindowAdapter() {
			private Close close;
			{
				this.close = closeItem;
			}
			public void windowClosing(WindowEvent e) {
				this.close.close();
			}
		};
	}

}
