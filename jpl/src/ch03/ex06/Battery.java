package ch03.ex06;

public class Battery extends EnergySource{
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
