package ch03.ex06;

public class GasTank extends EnergySource{
	private int gasVolume;
	public GasTank() {
		this.gasVolume = 0;
	}
	public GasTank(int volume) {
		this.gasVolume = volume;
	}
	public boolean empty() {
		if(this.gasVolume == 0) {
			return true;
		} else {
			return false;
		}
	}
	public void refill(int volume) {
		this.gasVolume += volume;
	}
}
