package dc1_2;

import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFactory {

	public static Button getButton(ButtonType type) {

		switch(type) {
		case PULLDOWN_LIST : return getPullDownListButton();
			default : throw new IllegalArgumentException();
		}

	}

	private static Button getPullDownListButton() {
		Button button = new Button("▽");

		return button;
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
