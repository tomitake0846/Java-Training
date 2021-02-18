package dc3_3.view.config;

import java.util.function.Consumer;

import dc3_3.model.UserConfig;
import dc3_3.view.DigitalClock;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Font;

public class UserContextMenu {
	private static ContextMenu context;
	private static final String[] COLOR_LIST= {"white","lightGray","gray","darkGray","black","red",
			"pink","orange","yellow","green","magenta","cyan","blue"};
	private UserContextMenu() {};

	public static ContextMenu getContext() {
		if(UserContextMenu.context == null) {
			UserContextMenu.context = _init();
		}
		return UserContextMenu.context;
	}


	private static ContextMenu _init() {
		ContextMenu context = new ContextMenu();
		context.getItems().add(getFontFamilyMenu());
		context.getItems().add(getFontSizeMenu());
		context.getItems().add(getCharColorMenu());
		context.getItems().add(getBackGroundColorMenu());
		return context;
	}

	private static Menu getFontFamilyMenu() {
		Menu menu = new Menu(UserConfig.FONT_FAMILY);
		for (String family : Font.getFamilies()) {
			MenuItem item = new MenuItem(family);
			item.setOnAction(e -> {
				DigitalClock.config.setFontFamily(family);
			});
			menu.getItems().add(item);
		}
		return menu;
	}

	private static Menu getFontSizeMenu() {
		Menu menu = new Menu(UserConfig.FONT_SIZE);
		double[] fontSizeArray = {24,32,40,48,56,64,72};
		for(double fontSize : fontSizeArray) {
			MenuItem item = new MenuItem((int)fontSize+"");
			item.setOnAction(e -> {
				DigitalClock.config.setFontSize((int)fontSize+"");
			});
			menu.getItems().add(item);
		}
		return menu;
	}

	private static Menu getCharColorMenu() {
		return getColorMenu(UserConfig.CHAR_COLOR,c -> DigitalClock.config.setCharColor(c));
	}

	private static Menu getBackGroundColorMenu() {
		return getColorMenu(UserConfig.BG_COLOR,c -> DigitalClock.config.setBGColor(c));
	}

	private static Menu getColorMenu(String itemName,Consumer<String> consumer) {
		Menu menu = new Menu(itemName);
		for (String color : COLOR_LIST) {
			MenuItem item = new MenuItem(color);
			item.setOnAction(e -> {
				consumer.accept(color);
			});
			menu.getItems().add(item);
		}
		return menu;
	}
}
