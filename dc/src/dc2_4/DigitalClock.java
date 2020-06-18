package dc2_4;

import java.awt.MenuBar;

import dc2_4.menu.MyMenubar;
public class DigitalClock{
	public static final MyFrame frame;
	public static final ClockCanvas canvas;
	public static final MenuBar menubar;

	static {

		PropertyInfo property = PropertyInfo.instance;
		frame = new MyFrame(property);
		canvas = new ClockCanvas(property);
		menubar = new MyMenubar();
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
