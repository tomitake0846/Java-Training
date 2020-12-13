package ch03.ex08;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
	public void start(Stage stage) {
		ImageView view = new ImageView(getMyImage());

		StackPane pane = new StackPane();
		pane.getChildren().add(view);
		stage.setScene(new Scene(pane));
		stage.show();

	}

	private Image getMyImage() {
		Image image = new Image("ch03/ex08/shiba.jpg");
		int imageHeight = (int)image.getHeight();
		int imageWidth = (int)image.getWidth();
		int frameWidth = 10;
		FrameDefinition fd = new FrameDefinition(Color.GRAY) {
			@Override
			public boolean inFrame(int x, int y) {
				if(!(frameWidth <= x && x <= (imageWidth - frameWidth))) {
					return true;
				}
				if(!(frameWidth <= y && y <= (imageHeight - frameWidth))) {
					return true;
				}
				return false;
			}
		};
		//妙な加工はしない
		return ImageProcessor.transformWidhFrame(image, (x,y,c) -> c , fd);
	}

	public static void main(String[] args) throws IOException {
		Application.launch(args);
	}
}
