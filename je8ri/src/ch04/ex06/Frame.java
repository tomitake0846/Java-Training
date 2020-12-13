package ch04.ex06;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Frame extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		BorderPane pane = new BorderPane();

		HBox topBox = new HBox();
		topBox.setAlignment(Pos.CENTER);
		topBox.getChildren().add(new Button("Top"));
		pane.setTop(topBox);

		pane.setLeft(new Button("Left"));
		pane.setCenter(new Button("Center"));
		pane.setRight(new Button("Right"));

		HBox bottomBox = new HBox();
		bottomBox.setAlignment(Pos.CENTER);
		bottomBox.getChildren().add(new Button("Bottom"));
		pane.setBottom(bottomBox);

		stage.setScene(new Scene(pane));

		stage.setTitle("Hello");
		stage.show();
	}

}
