package dc1_3;

import java.awt.Frame;
public class MyFrame extends Frame implements Close{

	public MyFrame(PropertyInfo propertyInfo) {
//		super(propertyInfo.getClockTitle());
//		setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
//		setVisible(true);
	}

	public void close() {
		System.exit(0);
	}
}
