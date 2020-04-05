package dc2_1.logic;

import java.awt.Canvas;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import dc2_1.gui.ClockCanvas;
import dc2_1.gui.MyFrame;

public class DigitalClock {
	private JFrame myFrame;
	private Canvas canvas;
	public DigitalClock(String title,int width,int height) {
		this.myFrame = new MyFrame(title,width,height);
		this.canvas = new ClockCanvas(width,height);
		this.myFrame.add(this.canvas);
		this.myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
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
