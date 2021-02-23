package dc3_3.view;

import dc3_3.model.UserConfig;
import dc3_3.view.mainDisplay.TimeDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DigitalClock extends Application {

	public static final UserConfig config = UserConfig.getInstance();

	@Override
	public void start(Stage stage) {
		stage.initStyle(StageStyle.UNDECORATED);

		TimeDisplay td = new TimeDisplay();
		stage.setScene(new Scene(td,config.getClockWidth(),config.getClockHeight()));
		stage.setTitle(DigitalClock.config.getClockTitle());
		td.setOnMouseDragged(e -> {
			if(e.isPrimaryButtonDown()) {
				stage.setX(e.getScreenX());
				stage.setY(e.getScreenY());
			}
		});

		stage.show();
	}

	public void start(String... args) {
		launch(args);
	}
}
