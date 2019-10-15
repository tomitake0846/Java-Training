package ch06.ex05;

public enum TrafficLight {

	YELLOW {
		public Color getColor() {
			return new Color(255,241,0);
		}
	},
	RED{
		public Color getColor() {
			return new Color(255,241,0);
		}
	},
	GREEN{
		public Color getColor() {
			return new Color(255,241,0);
		}
	};

	public abstract Color getColor();

}
