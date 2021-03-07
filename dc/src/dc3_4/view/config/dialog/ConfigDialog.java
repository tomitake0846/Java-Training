package dc3_4.view.config.dialog;

import dc3_4.model.config.UserConfig;
import dc3_4.view.config.dialog.configDialogComponent.ChoiceBoxSupplier;
import dc3_4.view.config.dialog.configDialogComponent.ColorPickerSupplier;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public final class ConfigDialog extends Stage {
	public static final String[] COLOR_LIST = {"white","lightGray","gray","darkGray","black","red",
			"pink","orange","yellow","green","magenta","cyan","blue"};

	public static final Double[] FONT_SIZE_ARRAY = {24.0,32.0,40.0,48.0,56.0,64.0,72.0};
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
		BorderPane border = new BorderPane();
		border.setCenter(getConfigPane());
		border.setBottom(getButtonsHBox());

		Scene scene = new Scene(border,400,300);
		setTitle("Digital Clock Config");
		setScene(scene);
	}

	private GridPane getConfigPane() {
		GridPane configPane = new GridPane();
		Label fontFamilyLabel = toLabel(UserConfig.FONT_FAMILY);
		Label fontSizeLabel = toLabel(UserConfig.FONT_SIZE);
		Label charColorLabel = toLabel(UserConfig.CHAR_COLOR);
		Label BGColorLabel = toLabel(UserConfig.BG_COLOR);

		configPane.add(fontFamilyLabel, 0, 0);
		GridPane.setHalignment(fontFamilyLabel, HPos.RIGHT);

		configPane.add(fontSizeLabel, 0, 1);
		GridPane.setHalignment(fontSizeLabel, HPos.RIGHT);

		configPane.add(charColorLabel, 0, 2);
		GridPane.setHalignment(charColorLabel, HPos.RIGHT);

		configPane.add(BGColorLabel, 0, 3);
		GridPane.setHalignment(BGColorLabel, HPos.RIGHT);

		ChoiceBoxSupplier cbf = new ChoiceBoxSupplier();

		configPane.add(cbf.getFontFamilyChoiceBox(), 1, 0);
		configPane.add(cbf.getFontSizeChoiceBox(), 1, 1);
		configPane.add(ColorPickerSupplier.getCharColorPicker(), 1, 2);
		configPane.add(ColorPickerSupplier.getBGColorPicker(), 1, 3);

		configPane.setVgap(5);
		configPane.setHgap(5);
		configPane.setAlignment(Pos.CENTER);

		return configPane;
	}
	private Label toLabel(String itemName) {
		Label label = new Label(itemName+" : ");
		return label;
	}

	private HBox getButtonsHBox() {
		HBox box = new HBox();
		box.getChildren().addAll(getUpdateButton(),getCancelButton());
		box.setPadding(new Insets(15, 12, 15, 12));
		box.setSpacing(10);
		box.setAlignment(Pos.BASELINE_RIGHT);
		return box;
	}
	private Button getUpdateButton() {
		Button updateButton = new Button("ok");
		updateButton.setOnAction(e -> {
			ChoiceBoxSupplier.update();
			ColorPickerSupplier.update();
			this.hide();
		});
		updateButton.setPrefSize(80, 20);
		return updateButton;
	}

	private Button getCancelButton() {
		Button cancelButton = new Button("cancel");
		cancelButton.setOnAction(e -> {
			this.hide();
		});
		cancelButton.setPrefSize(80, 20);
		return cancelButton;
	}

}
