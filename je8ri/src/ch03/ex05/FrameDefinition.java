package ch03.ex05;

import javafx.scene.paint.Color;

public abstract class FrameDefinition {

	private Color frameColor;

	public FrameDefinition(Color frameColor) {
		this.frameColor = frameColor;
	}

	public abstract boolean inFrame(int x,int y);

	public Color getFrameColor() {
		return this.frameColor;
	}
}
