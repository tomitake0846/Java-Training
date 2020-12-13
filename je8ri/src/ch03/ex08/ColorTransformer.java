package ch03.ex08;

import javafx.scene.paint.Color;

public interface ColorTransformer {
	Color apply(int x, int y, Color colorAtXY);
}
