package dc1_1;

public class DigitalClock{
	private MyFrame frame;
	private ClockCanvas canvas;
	public DigitalClock(String title,int width,int height) {
		this.frame = new MyFrame(title,width,height);
		this.canvas = new ClockCanvas(width,height);
		this.frame.add(canvas);
		this.frame.addWindowListener(ButtonFactory.createCloseButton());

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
