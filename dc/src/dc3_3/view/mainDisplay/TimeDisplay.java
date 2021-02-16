package dc3_3.view.mainDisplay;

import java.util.function.Consumer;

import dc3_3.model.Information;
import dc3_3.model.InformationFactory;
import dc3_3.model.UserConfig;
import dc3_3.view.DigitalClock;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.util.Duration;

public class TimeDisplay extends Label {
	private final Information time;
	public TimeDisplay() {
		this.time = InformationFactory.getTimeInstance();

		Timeline tl = getTimeline( (s) -> this.setText(this.time.get()));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
	}

	private Timeline getTimeline(Consumer<String> s) {
		Timeline t = new Timeline(new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				setFont(DigitalClock.config.getFont());
				setTextFill(UserConfig.toColor(DigitalClock.config.getCharColor()));
				setBackground(new Background(new BackgroundFill(
						UserConfig.toColor(DigitalClock.config.getBGColor()),
						new CornerRadii(0),
						Insets.EMPTY)));
				s.accept("");
			}
		}));
		return t;
	}
}
