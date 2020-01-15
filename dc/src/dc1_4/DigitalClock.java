package dc1_4;

import java.awt.MenuBar;

import dc1_4.menu.MyMenubar;

public class DigitalClock{
	public static final MyFrame frame;
	public static final ClockCanvas canvas;
	public static final MenuBar menubar;
	public static final ExtendedPreference prefs;
	public static final PropertyInfo property;
	static {
		property = PropertyInfo.instance;
		frame = new MyFrame(property);
		canvas = new ClockCanvas(property);
		menubar = new MyMenubar();
		prefs = new ExtendedPreference(property,frame);
		frame.add(canvas);
		frame.setMenuBar(menubar);
		frame.addWindowListener(ButtonFactory.getCloseButton(DigitalClock.frame));

	}

	public void run() {
		while(true) {
			DigitalClock.canvas.repaint();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.exit(0);
			}
		}
	}
}
