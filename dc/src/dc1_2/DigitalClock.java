package dc1_2;

import java.awt.MenuBar;

import dc1_2.menu.MyMenubar;

public class DigitalClock{
	public static final MyFrame frame;
	public static final ClockCanvas canvas;
	public static final MenuBar menubar;

	static {
		frame = new MyFrame(Config.TITLE,Config.WIDTH,Config.HEIGHT);
		canvas = new ClockCanvas(Config.WIDTH,Config.HEIGHT);
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
