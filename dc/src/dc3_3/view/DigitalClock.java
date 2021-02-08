package dc3_3.view;

import dc3_3.view.mainDisplay.TimeDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DigitalClock extends Application {
	@Override
	public void start(Stage stage) {
		stage.setScene(new Scene(new TimeDisplay()));
		stage.setTitle("Digital Clock");
		stage.show();
	}

	public void start(String... args) {
		launch(args);
	}
}
