package dc3_1.view;

import java.util.function.Consumer;

import dc3_1.model.Information;
import dc3_1.model.InformationFactory;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DigitalClock extends Application {
	private final Information time;
	public DigitalClock() {
		this.time = InformationFactory.getTimeInstance();
	}
	@Override
	public void start(Stage stage) {
		Label timeLabel = new Label();
		Timeline tl = getTimeline((s) -> timeLabel.setText(this.time.get()));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();

		timeLabel.setFont(new Font(60));
		stage.setScene(new Scene(timeLabel));
		stage.setTitle("Digital Clock");
		stage.show();
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

	public static void main(String[] args) {
		launch(args);
	}
}
