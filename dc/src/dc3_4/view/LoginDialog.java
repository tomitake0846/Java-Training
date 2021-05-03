package dc3_4.view;

import dc3_4.controller.RESTLogic.RESTLogic;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LoginDialog extends Stage {
	public static LoginDialog dialog;
	public static Stage getInstance() {
		if(LoginDialog.dialog == null) {
			LoginDialog.dialog = new LoginDialog();
		}
		return LoginDialog.dialog;
	}

	private LoginDialog() {
		BorderPane border = new BorderPane();

		TextField userIDField = new TextField();
		TextField passwordField = new TextField();

		border.setCenter(getLoginFormPane(userIDField,passwordField));
		border.setBottom(getButtonHBox(userIDField,passwordField));

		Scene scene = new Scene(border,300,150);
		setTitle("login");
		setScene(scene);
	}

	private GridPane getLoginFormPane(TextField userIDField,TextField passwordField) {
		GridPane loginForm = new GridPane();

		Label userID = new Label("user id:");
		loginForm.add(userID, 0, 0);
		loginForm.add(userIDField,1,0);
		GridPane.setHalignment(userID, HPos.RIGHT);

		Label password = new Label("password:");
		loginForm.add(password, 0, 1);
		loginForm.add(passwordField,1,1);
		GridPane.setHalignment(password, HPos.RIGHT);

		loginForm.setVgap(5);
		loginForm.setHgap(5);
		loginForm.setAlignment(Pos.CENTER);

		return loginForm;
	}

	private HBox getButtonHBox(TextField userIDField,TextField passwordField) {
		HBox box = new HBox();
		box.getChildren().addAll(getLoginButton(userIDField,passwordField),getRegisterButton());
		box.setPadding(new Insets(15, 12, 15, 12));
		box.setSpacing(10);
		box.setAlignment(Pos.BASELINE_CENTER);
		return box;
	}

	private Button getLoginButton(TextField userIDField,TextField passwordField) {
		Button button = new Button("login");
		button.setOnAction(e -> {
			String userID = userIDField.getText();
			String password = passwordField.getText();

			//challenging login
			//if failed the login , display an error popup
			//else, proceed to load config.
			RESTLogic.login(userID, password,
					errMsg -> Popup.showInfoPopup(errMsg) ,
					id -> RESTLogic.config(id,
							errMsg -> Popup.showInfoPopup(errMsg),
							() -> {
								this.hide();
								DigitalClock.getInstance().show();
							}));
		});
		return button;
	}

	private Button getRegisterButton() {
		Button button = new Button("register");
		button.setOnAction(e -> {
			this.hide();
			RegisterDialog.getInstance().show();
		});
		return button;
	}

}
