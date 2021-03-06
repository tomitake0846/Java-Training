package dc3_4.view;

import dc3_4.model.config.ExtendedPreference;
import dc3_4.model.config.UserConfig;
import dc3_4.view.config.menuBar.DCMenuBar;
import dc3_4.view.mainDisplay.TimeDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DigitalClock extends Application {

	public static final UserConfig config = UserConfig.getInstance();
	public static final ExtendedPreference USER_CONFIG_PREFERENCE = new ExtendedPreference();
	public static Runnable exitEvent = () -> {throw new IllegalStateException();};
	@Override
	public void start(Stage stage) {
		DigitalClock.exitEvent = exitEvent(stage);
		DigitalClock.USER_CONFIG_PREFERENCE.loadConfig();

		VBox box = new VBox();
		Scene scene = new Scene(box,config.getClockWidth(),config.getClockHeight());

		//MenubarInit
		box.getChildren().addAll(DCMenuBar.getInstance());

		//TimeDisplay init
		TimeDisplay td = new TimeDisplay();
		td.moveProcessingInit(stage::setX, stage::setY,stage::getX,stage::getY);
		box.getChildren().addAll(td);

		stage.setScene(scene);
		stage.setTitle(DigitalClock.config.getClockTitle());
		stage.setX(config.X());
		stage.setY(config.Y());
		stage.setOnCloseRequest(e -> {
			exitEvent.run();
		});

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
