package dc3_4.view.config.dialog.configDialogComponent;

import java.util.function.Consumer;

import javafx.scene.control.ChoiceBox;

public class MyChoiceBox<T> extends ChoiceBox<T> {
	private Consumer<T> updateEvent;
	public void setUpdater(Consumer<T> updateEvent) {
		this.updateEvent = updateEvent;
	}
	public void activateUpdateEvent() {
		this.updateEvent.accept(this.getSelectionModel().getSelectedItem());
	}
}
