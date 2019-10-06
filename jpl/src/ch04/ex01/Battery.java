package ch04.ex01;

public class Battery implements EnergySource{
	private int batteryVolume;
	public Battery() {
		this.batteryVolume = 0;
	}
	public Battery(int volume) {
		this.batteryVolume = volume;
	}
	public boolean empty() {
		if(this.batteryVolume == 0) {
			return true;
		} else {
			return false;
		}
	}
	public void refill(int volume) {
		this.batteryVolume += volume;
	}
}
