package ch03.ex15;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {
	private Image in;
	private List<UnaryOperator<Color>> pendingOperations;

	public LatentImage(Image in) {
		this.in = in;
	}

	public LatentImage transform(UnaryOperator<Color> f) {
		pendingOperations.add(f);
		return this;
	}

	public Image toImage() {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		WritableImage out = new WritableImage(width,height);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				Color c = in.getPixelReader().getColor(x, y);
				for(UnaryOperator<Color> f : pendingOperations) {
					c = f.apply(c);
				}
				out.getPixelWriter().setColor(x, y, c);
			}
		}
		return out;
	}

	public Image toImageWithParallel() {
		int n = Runtime.getRuntime().availableProcessors();
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();

		Color[][] out = new Color[height][width];

		try {
			ExecutorService pool = Executors.newCachedThreadPool();

			for(int i=0; i < n; i ++) {
				int fromY = i + height / n;
				int toY = (i + 1) * height / n;
				pool.submit(() -> {
					for(int x = 0; x < width; x++) {
						for(int y = fromY; y < toY; y++) {
							Color c = in.getPixelReader().getColor(x, y);

							for(UnaryOperator<Color> f : pendingOperations) {
								c = f.apply(c);
							}
							out[y][x] = c;
						}
					}
				});
			}

			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.HOURS);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return toImage(out);
	}

	public static Color[][] toColorArrays(Image in) {
		int width = (int) in.getWidth();
		int height = (int) in.getHeight();
		Color[][] colors = new Color[height][width];

		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				colors[y][x] = in.getPixelReader().getColor(x, y);
			}
		}

		return colors;
	}

	public static Image toImage(Color[][] in) {
		int width = in[0].length;
		int height = in.length;
		WritableImage out = new WritableImage(width,height);
		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				out.getPixelWriter().setColor(x, y, in[y][x]);
			}
		}
		return out;
	}
}
