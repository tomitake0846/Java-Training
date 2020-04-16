package dc2_1;

import dc2_1.logic.DigitalClock;

public class dc2_1_Main {
	public static void main(String[] args) {
		DigitalClock clock = new DigitalClock("Digital Clock",600,300);
		clock.run();
	}
}
