package dc3_4.view.config.dialog;

import java.util.function.Consumer;

import dc3_4.controller.config.ConfigUpdater;
import dc3_4.model.config.UserConfig;
import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public final class ConfigDialog extends Stage {
	private static final String[] COLOR_LIST= {"white","lightGray","gray","darkGray","black","red",
			"pink","orange","yellow","green","magenta","cyan","blue"};
	private static final Double[] FONT_SIZE_ARRAY = {24.0,32.0,40.0,48.0,56.0,64.0,72.0};
	private static ConfigDialog dialog;
	private ConfigDialog() {
		init();
	};
	public static Stage getInstance() {
		if(dialog == null) {
			ConfigDialog.dialog = new ConfigDialog();
		}
		return ConfigDialog.dialog;
	}

	private void init() {
		VBox configPane = new VBox();
		Scene scene = new Scene(configPane,800,600);
		ChoiceBoxSupplier cbf = new ChoiceBoxSupplier();

		//update button init
		Button updateButton = new Button("ok");
		updateButton.setOnAction(e -> {
			for(Node node : configPane.getChildren()) {
				if(node instanceof MyChoiceBox) {
					((MyChoiceBox<?>)node).activateUpdateEvent();
				}
			}
			this.hide();
		});

		Button cancelButton = new Button("cancel");
		cancelButton.setOnAction(e -> {
			this.hide();
		});

		configPane.getChildren().addAll(
				cbf.getFontFamilyChoiceBox(),
				cbf.getFontSizeChoiceBox(),
				cbf.getCharColorChoiceBox(),
				cbf.getBGColorChoiceBox(),
				updateButton,
				cancelButton
				);

		setScene(scene);
	}

	//choice box factory
	private class ChoiceBoxSupplier {
		private final UserConfig config = UserConfig.getInstance();
		private MyChoiceBox<String> getFontFamilyChoiceBox() {
			return getChoiceBox(Font.getFamilies().toArray(new String[0]),
					this.config.getFontFamily(),
					"Select clock's font family.",
					ConfigUpdater.fontFamilyUpdater()
					);
		}
		private MyChoiceBox<Double> getFontSizeChoiceBox() {
			return getChoiceBox(ConfigDialog.FONT_SIZE_ARRAY,
					this.config.getFontSize(),
					"Select clock's font size.",
					ConfigUpdater.fontSizeUpdater()
					);
		}
		private MyChoiceBox<String> getCharColorChoiceBox() {
			return getChoiceBox(ConfigDialog.COLOR_LIST,
					this.config.getCharColor(),
					"Select clock's character color.",
					ConfigUpdater.charColorUpdater()
					);
		}
		private MyChoiceBox<String> getBGColorChoiceBox() {
			return getChoiceBox(ConfigDialog.COLOR_LIST,
					this.config.getBGColor(),
					"Select clock's background color.",
					ConfigUpdater.BGColorUpdater()
					);
		}
		private <E> MyChoiceBox<E> getChoiceBox(E[] items, E defaultValue,String tooltipMessage,Consumer<E> updateEvent){
			MyChoiceBox<E> cb = new MyChoiceBox<>();
			cb.setItems(FXCollections.observableArrayList(items));
			cb.getSelectionModel().select(defaultValue);
			cb.setUpdater(updateEvent);
			cb.setTooltip(new Tooltip(tooltipMessage));
			return cb;
		}
	}
	private static class MyChoiceBox<T> extends ChoiceBox<T> {
		private Consumer<T> updateEvent;
		public void setUpdater(Consumer<T> updateEvent) {
			this.updateEvent = updateEvent;
		}
		public void activateUpdateEvent() {
			this.updateEvent.accept(this.getSelectionModel().getSelectedItem());
		}
	}
}
