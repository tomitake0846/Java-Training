package dc1_2;

import java.awt.Frame;

public class MyFrame extends Frame implements Close{

	public MyFrame(String title,int width,int height) {
		super(title);
		setSize(width,height);
		setVisible(true);
	}

	public void close() {
		System.exit(0);
	}
}
