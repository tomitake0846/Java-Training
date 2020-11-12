package ch03.ex05;


import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class ImageProcessor {
	public static Image transform(Image in, ColorTransformer f) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		WritableImage out = new WritableImage(width,height);
		for(int x=0;x<width; x++) {
			for(int y=0;y<height; y++) {
				out.getPixelWriter().setColor(x,y,f.apply(x,y,in.getPixelReader().getColor(x,y)));
			}
		}

		return out;
	}

	public static Image transformWidhFrame(Image in,ColorTransformer f,FrameDefinition fd) {

		return ImageProcessor.transform(in,(x,y,c) -> {
			if(fd.inFrame(x, y)) return fd.getFrameColor();
			else return f.apply(x,y,c);
		});

	}
}
