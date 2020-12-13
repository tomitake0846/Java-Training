package ch04.ex04;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Frame extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	public Frame() {
	}

	@Override
	public void start(Stage stage) throws Exception {

		Pane mainPane = new Pane();
		mainPane.setPrefSize(300,200);

		double radius = 80;
		Circle c = new Circle(radius);

		mainPane.getChildren().add(c);
		Scene mainScene = new Scene(mainPane);
		stage.setScene(mainScene);

		c.centerXProperty().bind(Bindings.divide(mainScene.widthProperty(), 2));
		c.centerYProperty().bind(Bindings.divide(mainScene.heightProperty(), 2));

		c.radiusProperty().bind(Bindings.min(
				Bindings.divide(mainScene.widthProperty(), 2),
				Bindings.divide(mainScene.heightProperty(), 2)));

		stage.setTitle("Hello");
		stage.show();
	}

	public ReadOnlyDoubleProperty min(Scene mainScene) {
		return mainScene.getWidth() < mainScene.getHeight() ? mainScene.widthProperty() : mainScene.heightProperty();
	}

}
