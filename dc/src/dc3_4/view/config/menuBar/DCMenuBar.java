package dc3_4.view.config.menuBar;

import dc3_4.view.config.dialog.ConfigDialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public final class DCMenuBar extends MenuBar{

	private static DCMenuBar menu;

	public static MenuBar getInstance() {
		if(menu == null) {
			menu = new DCMenuBar();
		}
		return DCMenuBar.menu;
	}

	private DCMenuBar() {
		// menu item definition
		MenuItem configItem = new MenuItem("config");
		configItem.setOnAction(e -> {
			ConfigDialog.getInstance().show();
		});

		// add menu item to Menu
		Menu fileMenu = new Menu("file");
		fileMenu.getItems().addAll(configItem);

		this.getMenus().addAll(fileMenu);
	}
}
