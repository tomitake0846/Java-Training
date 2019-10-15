package dc1_2;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

public class MenubarCreator {
//	ClockCanvas canvas;
//
//	public MenubarCreator(ClockCanvas canvas) {
//		this.canvas = canvas;
//	}

	public MenuBar getMenuber() {
		MenuBar bar = new MenuBar();
		bar.add(getMainMenu());

		return bar;
	}
	private Menu getMainMenu() {
		Menu menu = new Menu("menu");
		menu.add(new MenuItem("property"));
		return menu;
	}
}
