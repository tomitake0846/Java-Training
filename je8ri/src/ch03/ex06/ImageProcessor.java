package ch03.ex06;

import java.util.function.BiFunction;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class ImageProcessor{
	public static <T> Image transform(Image in,BiFunction<Color,T> f, T arg) {

		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		WritableImage out = new WritableImage(width,height);

		for(int x=0;x<width; x++) {
			for(int y=0;y<height; y++) {
//				out.getPixelWriter().setColor(x,y,f.apply(x,y,in.getPixelReader().getColor(x,y)));
			}
		}

		return out;
	}

//	public static void test(Image image) {
//		Image brightendImage = transform(image ,(c, factor) -> c.deriveColor(0,1,factor,1),1.2);
//	}
}
