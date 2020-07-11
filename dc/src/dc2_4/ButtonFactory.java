package dc2_4;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class ButtonFactory {

	public static JButton getButton(ButtonType type,ActionListener e) {

		switch(type) {
		case PULLDOWN_LIST : return getPullDownListButton(e);
		case PROPERTY_UPDATE : return getPropertyUpdateButton(e);
		case PROPERTY_CANCEL : return getPropertyCancelButton(e);
		case PROPERTY_RESET : return getPropertyResetButton(e);
			default : throw new IllegalArgumentException();
		}

	}

	private static JButton getPullDownListButton(ActionListener e) {
		JButton JButton = new JButton("▽");
		JButton.addActionListener(e);
		return JButton;
	}
	private static JButton getPropertyUpdateButton(ActionListener e) {
		JButton JButton = new JButton("OK");
		JButton.addActionListener(e);
		return JButton;
	}
	private static JButton getPropertyCancelButton(ActionListener e) {
		JButton JButton = new JButton("cancel");
		JButton.addActionListener(e);
		return JButton;
	}
	private static JButton getPropertyResetButton(ActionListener e) {
		JButton JButton = new JButton("reset");
		JButton.addActionListener(e);
		return JButton;
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
