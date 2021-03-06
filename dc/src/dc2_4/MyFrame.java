package dc2_4;

import javax.swing.JFrame;
public class MyFrame extends JFrame implements Close{

	public MyFrame(PropertyInfo propertyInfo) {
		super(propertyInfo.getClockTitle());
		setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		setVisible(true);
	}

	public void close() {
		DigitalClock.prefs.positionUpdate();
		System.exit(0);
	}
}
