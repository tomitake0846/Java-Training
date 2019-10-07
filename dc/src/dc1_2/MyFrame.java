package dc1_2;

import java.awt.Frame;

public class MyFrame extends Frame{
	private String title;
	public MyFrame(String title,int width,int height) {
		super(title);
		this.title = title;
		setSize(width,height);
		setVisible(true);
	}
}
