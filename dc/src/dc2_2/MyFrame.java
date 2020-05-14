package dc2_2;

import javax.swing.JFrame;

public class MyFrame extends JFrame implements Close{

	public MyFrame(PropertyInfo propertyInfo) {
		super(propertyInfo.getClockTitle());
		setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		setVisible(true);
	}

	public void close() {
		System.exit(0);
	}
}
