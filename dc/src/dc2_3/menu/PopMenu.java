package dc2_3.menu;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc2_3.DigitalClock;
import dc2_3.PropertyInfo;

public class PopMenu extends PopupMenu implements ActionListener{

	private final int POP_FONTSIZE = 20;
	private PropertyInfo propertyInfo;
	private String[] colorList;
	public PopMenu() {
		propertyInfo = PropertyInfo.instance;
		this.colorList = new String[]{"white","lightGray","gray","darkGray","black","red",
				"pink","orange","yellow","green","magenta","cyan","blue"};
		this.add(getFontFamilyMenu());
		this.add(getFontSizeMenu());
		this.add(getCharColorMenu());
		this.add(getBGColorMenu());
		this.add(getCloseMenu());
		Font font = new Font("Serif",0,POP_FONTSIZE);
		setFont(font);
	}

	private abstract class PropertyMenu extends Menu implements ActionListener {
		public PropertyMenu(String label) {
			super(label);
			this.addActionListener(this);
		}

		protected void setParameter(String...strings ) {
			for(String str : strings) {
				this.add(new MenuItem(str));
			}
		}
	};

	private MenuItem getFontFamilyMenu() {
		PropertyMenu menu = new PropertyMenu("FontFamily") {
			{
				String[] fontFamilyList = GraphicsEnvironment.getLocalGraphicsEnvironment()
						.getAvailableFontFamilyNames();

				setParameter(fontFamilyList);
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFontFamily = e.getActionCommand();
				propertyInfo.setFontFamily(selectedFontFamily);
				DigitalClock.canvas.repaint();
			}
		};

		return menu;
	}

	private Menu getFontSizeMenu() {
		PropertyMenu menu = new PropertyMenu("FontSize") {
			{
				setParameter("20","26","32","40","48","56");
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFontSize = e.getActionCommand();
				propertyInfo.setFontSize(selectedFontSize);
				int clockWidth = propertyInfo.getClockWidth();
				int clockHeight = propertyInfo.getClockHeight();
				DigitalClock.myWindow.setSize(clockWidth,clockHeight);
				DigitalClock.canvas.repaint();
			}
		};
		return menu;
	}

	private MenuItem getCharColorMenu() {
		PropertyMenu menu = new PropertyMenu("CharColor") {
			{
				setParameter(colorList);
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedCharColor = e.getActionCommand();
				propertyInfo.setCharColor(selectedCharColor);
				DigitalClock.canvas.repaint();
			}
		};
		return menu;
	}

	private MenuItem getBGColorMenu() {
		PropertyMenu menu = new PropertyMenu("BackGround Color") {
			{
				setParameter(colorList);
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedBGColor = e.getActionCommand();
				propertyInfo.setBGColor(selectedBGColor);
				DigitalClock.canvas.repaint();
			}
		};
		return menu;
	}

	private MenuItem getCloseMenu() {
		MenuItem item = new MenuItem("close");
		item.addActionListener(this);
		return item;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "close" :
			DigitalClock.myWindow.close();
		}

	}
}
