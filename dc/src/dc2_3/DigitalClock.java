package dc2_3;

import java.awt.MenuBar;

import dc2_3.menu.MyMenubar;
import dc2_3.menu.PopMenu;
public class DigitalClock{
	public static final MyFrame frame;
	public static final ClockCanvas canvas;
	public static final MenuBar menubar;
	public static final MyWindow myWindow;

	static {

		PopMenu pop = new PopMenu();
		PropertyInfo property = PropertyInfo.instance;
		frame = new MyFrame(property);
		canvas = new ClockCanvas(property);
		canvas.addMouseListener(new MouseEvent(pop));
		canvas.add(pop);
		menubar = new MyMenubar();
		myWindow = new MyWindow(frame,property);
		myWindow.add(canvas);
		myWindow.addWindowListener(ButtonFactory.getCloseButton(DigitalClock.myWindow));
//		frame.add(canvas);
//		frame.setMenuBar(menubar);
//		frame.addWindowListener(ButtonFactory.getCloseButton(DigitalClock.frame));
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
