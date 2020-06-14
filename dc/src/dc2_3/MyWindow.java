package dc2_3;

import java.awt.Frame;
import java.awt.Window;

public class MyWindow extends Window implements Close{

	public MyWindow(Frame owner,PropertyInfo propertyInfo) {
		super(owner);
		setSize(propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
		setVisible(true);
	}

	@Override
	public void close() {

		System.exit(0);

	}

}
