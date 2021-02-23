package dc3_4.view;

import dc3_4.model.config.ExtendedPreference;
import dc3_4.model.config.UserConfig;
import dc3_4.view.mainDisplay.TimeDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DigitalClock extends Application {

	public static final UserConfig config = UserConfig.getInstance();
	public static final ExtendedPreference USER_CONFIG_PREFERENCE = new ExtendedPreference();
	public static Runnable exitEvent = () -> {throw new IllegalStateException();};
	@Override
	public void start(Stage stage) {
		DigitalClock.exitEvent = exitEvent(stage);
		DigitalClock.USER_CONFIG_PREFERENCE.loadConfig();

		TimeDisplay td = new TimeDisplay();
		stage.setScene(new Scene(td,config.getClockWidth(),config.getClockHeight()));
		td.setOnMouseDragged(e -> {
			if(e.isPrimaryButtonDown()) {
				stage.setX(e.getScreenX());
				stage.setY(e.getScreenY());
			}
		});

		stage.initStyle(StageStyle.UNDECORATED);
		stage.setTitle(DigitalClock.config.getClockTitle());
		stage.setX(config.X());
		stage.setY(config.Y());

		stage.show();
	}
	private Runnable exitEvent(Stage stage) {
		return () -> {
			config.setX(stage.getX());
			config.setY(stage.getY());
			USER_CONFIG_PREFERENCE.updateConfig();
			System.exit(0);
		};
	}

	public void start(String... args) {
		launch(args);
	}
}
