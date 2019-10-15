package dc1_2;

import java.awt.MenuBar;

public class DigitalClock{
	private MyFrame frame;
	private ClockCanvas canvas;
	private MenuBar menubar;
	public DigitalClock(String title,int width,int height) {
		this.frame = new MyFrame(title,width,height);
		this.canvas = new ClockCanvas(width,height);
		this.menubar = new MenubarCreator().getMenuber();
		this.frame.add(canvas);
		this.frame.setMenuBar(menubar);
		this.frame.addWindowListener(ButtonFactory.getButton(ButtonType.CLOSE));

	}

	public void run() {
		while(true) {
			this.canvas.repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.exit(0);
			}
		}
	}

}
