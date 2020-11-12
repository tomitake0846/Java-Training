package ch04.ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Frame extends Application{

	private PrintStringManager text;

	public static void main(String[] args) {
		launch(args);
	}

	public Frame() {
		this.text = new PrintStringManager();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Label message = new Label(this.text.getText());
		message.setFont(new Font(100));

		HBox box = new HBox(10);
		TextField textField = new TextField(this.text.getText());
		message.textProperty().bind(textField.textProperty());

		box.getChildren().addAll(message,textField);



		stage.setScene(new Scene(box));

		stage.setTitle("Hello");
		stage.show();
	}
}
