package dc3_4.view;

import dc3_4.model.config.ExtendedPreference;
import dc3_4.model.config.UserConfig;
import dc3_4.view.config.menuBar.DCMenuBar;
import dc3_4.view.mainDisplay.TimeDisplay;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DigitalClock extends Stage{

	public static final UserConfig config = UserConfig.getInstance();
	public static final ExtendedPreference USER_CONFIG_PREFERENCE = new ExtendedPreference();
	public static Runnable exitEvent = () -> {throw new IllegalStateException();};

	private static DigitalClock clock;
	public static Stage getInstance() {
		if(clock == null) {
			clock = new DigitalClock();
		}
		return clock;
	}

	private DigitalClock() {
		DigitalClock.exitEvent = exitEvent(this);
		DigitalClock.USER_CONFIG_PREFERENCE.loadConfig();

		BorderPane bp = new BorderPane();
		Scene scene = new Scene(bp,config.getClockWidth(),config.getClockHeight());

		//MenubarInit
		bp.setTop(DCMenuBar.getInstance());

		//TimeDisplay init
		TimeDisplay td = new TimeDisplay();
		td.moveProcessingInit(this::setX, this::setY,this::getX,this::getY);
		td.heightProptery().bind(this.heightProperty());
		td.widthProptery().bind(this.widthProperty());

		bp.setCenter(td);

		this.setScene(scene);
		this.setTitle(DigitalClock.config.getClockTitle());
		this.setX(config.X());
		this.setY(config.Y());
		this.setOnCloseRequest(e -> {
			exitEvent.run();
		});
	}

	private Runnable exitEvent(Stage stage) {
		return () -> {
			config.setX(stage.getX());
			config.setY(stage.getY());
			USER_CONFIG_PREFERENCE.updateConfig();
			System.exit(0);
		};
	}

}
