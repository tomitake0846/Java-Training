package dc1_4;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFactory {

	public static Button getButton(ButtonType type,ActionListener e) {

		switch(type) {
		case PULLDOWN_LIST : return getPullDownListButton(e);
		case PROPERTY_UPDATE : return getPropertyUpdateButton(e);
			default : throw new IllegalArgumentException();
		}

	}

	private static Button getPullDownListButton(ActionListener e) {
		Button button = new Button("▽");
		button.addActionListener(e);
		return button;
	}
	private static Button getPropertyUpdateButton(ActionListener e) {
		Button button = new Button("OK");
		button.addActionListener(e);
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
