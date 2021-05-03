package dc3_4.view;

import dc3_4.controller.RESTLogic.RESTLogic;
import dc3_4.model.config.UserConfig;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class RegisterDialog extends Stage {
	public static RegisterDialog dialog;
	public static Stage getInstance() {
		if(RegisterDialog.dialog == null) {
			RegisterDialog.dialog = new RegisterDialog();
		}
		return RegisterDialog.dialog;
	}
	private RegisterDialog() {
		BorderPane border = new BorderPane();

		TextField userIDField = new TextField();
		TextField passwordField = new PasswordField();
		TextField cofirmPasswordField = new PasswordField();

		border.setCenter(getRegisterFormPane(userIDField,passwordField,cofirmPasswordField));
		border.setBottom(getButtonHBox(userIDField,passwordField,cofirmPasswordField));

		Scene scene = new Scene(border,300,250);
		setTitle("register");
		setScene(scene);
	}

	private GridPane getRegisterFormPane(TextField userIDField,TextField passwordField,TextField confirmPasswordField) {
		GridPane registerForm = new GridPane();

		Label userID = new Label("user id:");
		registerForm.add(userID, 0, 0);
		registerForm.add(userIDField,1,0);
		GridPane.setHalignment(userID, HPos.RIGHT);

		Label password = new Label("password:");
		registerForm.add(password, 0, 1);
		registerForm.add(passwordField,1,1);
		GridPane.setHalignment(password, HPos.RIGHT);

		Label confirmPassword = new Label("comfirm password:");
		registerForm.add(confirmPassword, 0, 2);
		registerForm.add(confirmPasswordField,1,2);
		GridPane.setHalignment(confirmPassword, HPos.RIGHT);

		registerForm.setVgap(5);
		registerForm.setHgap(5);
		registerForm.setAlignment(Pos.CENTER);

		return registerForm;
	}

	private HBox getButtonHBox(TextField userIDField,TextField passwordField,TextField confirmPasswordField) {
		HBox box = new HBox();
		box.getChildren().addAll(getRegisterButton(userIDField,passwordField,confirmPasswordField),getCancelButton());
		box.setPadding(new Insets(15, 12, 15, 12));
		box.setSpacing(10);
		box.setAlignment(Pos.BASELINE_CENTER);
		return box;
	}

	private Button getRegisterButton(TextField userIDField,TextField passwordField,TextField confirmPasswordField) {
		Button button = new Button("register");
		button.setOnAction(e -> {
			String userID = userIDField.getText();
			String password = passwordField.getText();
			String confirmPassword = confirmPasswordField.getText();

			RESTLogic.regist(userID, password, confirmPassword,
					Popup::showInfoPopup,

					//processing when register successed.
					//config ... default config
					config -> {
						UserConfig userConfig = UserConfig.getInstance();
						userConfig.loadFromJson(config);
						this.hide();
						DigitalClock.getInstance().show();

					});
		});
		return button;
	}

	private Button getCancelButton() {
		Button button = new Button("cancel");
		button.setOnAction(e -> {
			this.hide();
			LoginDialog.getInstance().show();
		});

		return button;
	}
}
