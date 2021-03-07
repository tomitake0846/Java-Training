package dc3_4.view.config.dialog.configDialogComponent;

import java.util.function.Consumer;

import dc3_4.controller.config.ConfigUpdater;
import dc3_4.model.config.UserConfig;
import dc3_4.view.config.dialog.ConfigDialog;
import javafx.collections.FXCollections;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;

public class ChoiceBoxSupplier {
	private final UserConfig config = UserConfig.getInstance();
	private static MyChoiceBox<String> fontFamilyChoiceBox;
	private static MyChoiceBox<Double> fontSizeChoiceBox;

	public MyChoiceBox<String> getFontFamilyChoiceBox() {
		if( fontFamilyChoiceBox == null) {
			fontFamilyChoiceBox = getChoiceBox(Font.getFamilies().toArray(new String[0]),
					this.config.getFontFamily(),
					"Select clock's font family.",
					ConfigUpdater.fontFamilyUpdater()
					);
		}
		return fontFamilyChoiceBox;
	}
	public MyChoiceBox<Double> getFontSizeChoiceBox() {
		if( fontSizeChoiceBox == null ) {
			fontSizeChoiceBox = getChoiceBox(ConfigDialog.FONT_SIZE_ARRAY,
					this.config.getFontSize(),
					"Select clock's font size.",
					ConfigUpdater.fontSizeUpdater()
					);
		}
		return fontSizeChoiceBox;

	}

	public static void update() {
		fontFamilyChoiceBox.activateUpdateEvent();
		fontSizeChoiceBox.activateUpdateEvent();
	}

	private <E> MyChoiceBox<E> getChoiceBox(E[] items, E defaultValue,String tooltipMessage,Consumer<E> updateConsumer){
		MyChoiceBox<E> cb = new MyChoiceBox<>();
		cb.setItems(FXCollections.observableArrayList(items));
		cb.getSelectionModel().select(defaultValue);
		cb.setUpdater(updateConsumer);
		cb.setTooltip(new Tooltip(tooltipMessage));
		return cb;
	}
}
