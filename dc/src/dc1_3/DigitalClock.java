package dc1_3;

import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import dc1_2.menu.MyMenubar;
public class DigitalClock{
	public static final MyFrame frame;
	public static final ClockCanvas canvas;
	public static final MenuBar menubar;
	public static final MyWindow myWindow;

	static {

		PopupMenu pop = new PopupMenu("test");

		pop.add(new MenuItem("fuck"));
		pop.add(new MenuItem("fuck!"));
		pop.add(new MenuItem("fuck!!!"));

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
