package dc3_4.view.mainDisplay;

import java.util.function.Consumer;
import java.util.function.Supplier;

import dc3_4.model.config.UserConfig;
import dc3_4.model.display.Information;
import dc3_4.model.display.InformationFactory;
import dc3_4.view.DigitalClock;
import dc3_4.view.config.contextMenu.UserContextMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.util.Duration;

public class TimeDisplay extends Label {
	private final Information time;
	public TimeDisplay() {
		this.time = InformationFactory.getTimeInstance();

		// display settig
		Timeline tl = getTimeline( (s) -> this.setText(this.time.get()));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();

		// event setting
		setOpenContextMenuEvent();
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

	//set Event for open Context Menu
	private void setOpenContextMenuEvent() {
		setOnMousePressed(e -> {
			ContextMenu context = UserContextMenu.getContext();
			if(context.isShowing()) {
				context.hide();
			}
			if(e.isSecondaryButtonDown()) {
				context.show(this,e.getScreenX(),e.getScreenY());
			}
		});
	}

	//label move processing
	private delta d;
	public void moveProcessingInit(Consumer<Double> moveTargetXSetter, Consumer<Double> moveTargetYSetter,
			Supplier<Double> moveTargetXGetter,Supplier<Double> moveTargetYGetter) {

		this.setOnDragDetected(e -> {
			this.startFullDrag();
		});

		this.setOnMouseDragged(e -> {
			if(e.isPrimaryButtonDown()) {
				if(d == null) {
					d = new delta();
					d.dx = e.getScreenX() - moveTargetXGetter.get();
					d.dy = e.getScreenY() - moveTargetYGetter.get();
				}
				moveTargetXSetter.accept(e.getScreenX() - d.dx);
				moveTargetYSetter.accept(e.getScreenY() - d.dy);
				e.consume();
			}
		});

		this.setOnMouseDragReleased(e -> {
			d = null;
			e.consume();
		});
	}

	private class delta {
		private double dx;
		private double dy;
	}
}
