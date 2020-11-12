package ch04.ex01;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PrintStringManager {

	private StringProperty text = new SimpleStringProperty("Hello,JavaFX");

	public final StringProperty textProperty() {
		return this.text;
	}

	public final void setText(String newValue) {
		this.text.set(newValue);
	}

	public final String getText() {
		return this.text.get();
	}
}
