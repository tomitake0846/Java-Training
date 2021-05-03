package dc3_4;

import dc3_4.view.LoginDialog;
import javafx.application.Application;
import javafx.stage.Stage;

public class dc3_4Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginDialog.getInstance().show();
	}

}
