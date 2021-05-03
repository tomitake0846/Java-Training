package dc3_4.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class Popup {
	public static void showInfoPopup(String infoMsg) {
		Alert dialog = new Alert(AlertType.INFORMATION);
		dialog.setHeaderText(null);
		dialog.setContentText(infoMsg);
		dialog.showAndWait();
	}

	public static void showChoosePopup(String titleText,String infoMsg,Runnable whenOK,Runnable whenCancel) {
		Alert dialog = new Alert(AlertType.INFORMATION,null,
				ButtonType.OK,
				ButtonType.CANCEL);
		dialog.setTitle(titleText);
		dialog.setHeaderText(infoMsg);
		dialog.showAndWait().ifPresent(response -> {
			if(response == ButtonType.OK) whenOK.run();
			else whenCancel.run();
		});

	}
}
