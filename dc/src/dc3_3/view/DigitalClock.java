package dc3_3.view;

import dc3_3.model.UserConfig;
import dc3_3.view.config.UserContextMenu;
import dc3_3.view.mainDisplay.TimeDisplay;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DigitalClock extends Application {

	public static final UserConfig config = UserConfig.getInstance();

	@Override
	public void start(Stage stage) {
		TimeDisplay td = new TimeDisplay();
		setUserContextMenu(td);
		stage.setScene(new Scene(td,config.getClockWidth(),config.getClockHeight()));
		stage.setTitle(DigitalClock.config.getClockTitle());
		stage.show();
	}

	private void setUserContextMenu(TimeDisplay timeDisplay) {
		timeDisplay.setOnMousePressed(e -> {
			if(e.isSecondaryButtonDown()) {
				UserContextMenu.getContext().show(timeDisplay,e.getScreenX(),e.getScreenY());
			}
		});
	}

	public void start(String... args) {
		launch(args);
	}
}
