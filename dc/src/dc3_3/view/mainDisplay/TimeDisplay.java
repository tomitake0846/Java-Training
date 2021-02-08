package dc3_3.view.mainDisplay;

import java.util.function.Consumer;

import dc3_3.model.Information;
import dc3_3.model.InformationFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class TimeDisplay extends Label {
	private final Information time;
	public TimeDisplay() {
		this.time = InformationFactory.getTimeInstance();

		Timeline tl = getTimeline( (s) -> this.setText(this.time.get()));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
		this.setFont(new Font(60));
	}

	private Timeline getTimeline(Consumer<String> s) {
		Timeline t = new Timeline(new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				s.accept("");
			}
		}));
		return t;
	}
}
