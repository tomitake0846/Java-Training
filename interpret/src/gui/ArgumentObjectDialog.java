package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;

public class ArgumentObjectDialog extends JDialog{

	private SingleInstanceFrame frame;
	private String type;

	public ArgumentObjectDialog(String type) {
		this.type=type;
		frame = new SingleInstanceFrame();
		frame.setText(type);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	private void exit() {
		dispose();
	}

	public Object getInstance() {
		return frame.getInstance();
	}
}
