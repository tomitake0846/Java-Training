package dc3_4.view.mainDisplay;

import java.util.function.Consumer;
import java.util.function.Supplier;

import dc3_4.model.config.UserConfig;
import dc3_4.model.display.InformationFactory;
import dc3_4.view.config.contextMenu.UserContextMenu;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.util.Duration;

public class TimeDisplay extends Label {
	private final UserConfig config = UserConfig.getInstance();
	public TimeDisplay() {
		// display settig
		Timeline tl = getTimeline( (s) -> this.setText(s));
		setAlignment(Pos.CENTER);

		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();

		// event setting
		setOpenContextMenuEvent();
	}


	private Timeline getTimeline(Consumer<String> s) {
		Timeline t = new Timeline(new KeyFrame(Duration.millis(100),new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				s.accept(InformationFactory.getTimeInstance().get());
				repaint();
			}
		}));
		return t;
	}

	private void repaint() {
		setFont(config.getFont());
		setTextFill(UserConfig.toColor(config.getCharColor()));
		setPrefSize(widthProperty.get(), heightProperty.get());
		setBackground(new Background(new BackgroundFill(
				UserConfig.toColor(config.getBGColor()),
				new CornerRadii(0),
				Insets.EMPTY)));
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

	private DoubleProperty widthProperty = new SimpleDoubleProperty(getPrefWidth());
	public final DoubleProperty widthProptery() {return widthProperty;}
	public final void setWidthProperty(double newValue) {widthProperty.set(newValue);}
	public final double getBindedWidth() {return widthProperty.get();}

	private DoubleProperty heightProperty = new SimpleDoubleProperty(getPrefHeight());
	public final DoubleProperty heightProptery() {return heightProperty;}
	public final void setHeightProperty(double newValue) {heightProperty.set(newValue);}
	public final double getBindedHeight() {return heightProperty.get();}

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
