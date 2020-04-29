package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import gui.ArrayFrame;
import gui.SelectFrame;
import gui.SingleInstanceFrame;

public class FrameController implements ActionListener{

	public static final String SINGLE_INSTANCE = "SINGLE INSTANCE";
	public static final String ARRAY = "ARRAY";

	private SelectFrame selectFrame;
	private ArrayFrame arrayFrame;
	private SingleInstanceFrame siFrame;

	public FrameController() {
		selectFrame = new SelectFrame(this);

		arrayFrame = new ArrayFrame();
		arrayFrame.addWindowListener(getWindowListener());

		siFrame = new SingleInstanceFrame();
		siFrame.addWindowListener(getWindowListener());

		selectFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if(FrameController.SINGLE_INSTANCE.equals(command)) {

			siFrame.setVisible(true);

		} else if (FrameController.ARRAY.equals(command)) {

			arrayFrame.setVisible(true);

		} else {
			throw new UnsupportedOperationException("undefined action.");
		}

		selectFrame.setVisible(false);

	}


	private WindowListener getWindowListener() {
		WindowListener wl = new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				selectFrame.setVisible(true);
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}

		};

		return wl;
	}

}
