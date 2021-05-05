package dc3_4.view.config.menuBar;

import dc3_4.view.DigitalClock;
import dc3_4.view.LoginDialog;
import dc3_4.view.Popup;
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
		// add menu item to Menu
		Menu fileMenu = getFileMenu();
		Menu helpMenu = getHelpMenu();

		this.getMenus().addAll(fileMenu,helpMenu);
	}

	private Menu getFileMenu() {
		// menu item definition
		MenuItem configItem = new MenuItem("config");
		configItem.setOnAction(e -> {
			ConfigDialog.getInstance().show();
		});
		// add menu item to Menu
		Menu fileMenu = new Menu("file");
		fileMenu.getItems().addAll(configItem);
		return fileMenu;
	}
	private Menu getHelpMenu() {
		MenuItem logoutItem = new MenuItem("logout");
		logoutItem.setOnAction(e -> {
			Popup.showChoosePopup("Logout","Do you really want to log out?",
					() -> {
						LoginDialog.getInstance().setUserData("");
						DigitalClock.getInstance().hide();
						LoginDialog.getInstance().show();
					},
					() -> {});
		});
		Menu helpMenu = new Menu("help");
		helpMenu.getItems().addAll(logoutItem);
		return helpMenu;
	}
}
