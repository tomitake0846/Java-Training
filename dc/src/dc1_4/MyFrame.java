package dc1_4;

import java.awt.Frame;

public class MyFrame extends Frame implements Close{
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
