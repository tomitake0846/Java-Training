package dc1_2.dialog;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc1_2.ButtonFactory;
import dc1_2.ButtonType;
import dc1_2.PropertyInfo;

public class PropertyDialog extends abstractDialog{

	private final String FONT_FAMILY = "font Family";
	private final String FONT_NAME = "Font Name";
	private final String FONT_SIZE = "Font Size";

	private List fontFamilyList;
	private int FontListRows;
	private PropertyInfo propertyInfo;
	private Font propertyFont;

	private Button fontFamilyListButton;
	public PropertyDialog(){
		setSize(600,600);
		this.FontListRows = 1;
		this.propertyInfo = PropertyInfo.instance;

		this.propertyFont = new Font("Serif",0,this.propertyInfo.getFontSize());
		setFont(this.propertyFont);

		//font family initialization
		fontFamilyList = getFontFamilyList(this.FontListRows);
		add(fontFamilyList);
		changeSelectFont(this.propertyInfo.getFontFamily());

		//Button initialization
		fontFamilyListButton = ButtonFactory.getButton(ButtonType.PULLDOWN_LIST);
		fontFamilyListButton.setActionCommand(FONT_FAMILY);
		fontFamilyListButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals(FONT_FAMILY)) {
					if(FontListRows == 1) {
						FontListRows = 10;
					} else {
						FontListRows = 1;
					}
					repaint();
				}
			}

		});
		add(fontFamilyListButton);

	}
	public void paint(Graphics g) {
		g.drawString(FONT_FAMILY,20,100);
		g.drawString(FONT_NAME, 20, 130);
		g.drawString(FONT_SIZE, 20, 160);

//		fontFamilyList
		Dimension d = fontFamilyList.getPreferredSize(this.FontListRows);
		fontFamilyList.setBounds(120, 100, d.width, d.height);

		this.fontFamilyListButton.setBounds(120+d.width+10, 100, propertyInfo.getFontSize(),propertyInfo.getFontSize());
	}

	public List getFontFamilyList(int rows) {
		List list = new List(rows,false);
		list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFontFamily = e.getActionCommand();
				changeSelectFont(selectedFontFamily);
				FontListRows=1;
				repaint();
			}
		});

		for(String name : GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames()) {
			list.add(name);
		}
		return list;
	}

	private void changeSelectFont(String fontFamily) {

		int selectTarget=0;
		String[] items = this.fontFamilyList.getItems();
		for(int i=0;i<items.length;i++) {
			if(fontFamily.equals(items[i])) {
				selectTarget = i;
				break;
			}
		}
		this.fontFamilyList.select(selectTarget);
		repaint();
	}
	/*
	 * getSelectedItem() : String
	 * リストで選択されている項目を返す
	 *
	 * */

}
