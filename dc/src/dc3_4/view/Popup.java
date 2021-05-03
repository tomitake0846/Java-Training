package dc3_4.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Popup {
	public static void showInfoPopup(String infoMeg) {
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setHeaderText(null);
		dialog.setContentText(infoMeg);
		dialog.showAndWait();
	}
}
