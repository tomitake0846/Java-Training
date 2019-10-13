package ch06.ex04;

public enum TrafficLight {
	YELLOW(new Color(255,241,0)),
	RED(new Color(255,0,0)),
	GREEN(new Color(0,255,0));

	private final Color color;

	private TrafficLight(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

}
