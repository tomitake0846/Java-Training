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

public class PropertyDialog extends abstractDialog implements ActionListener{

	private final String FONT_FAMILY = "Font Family";
	private final String FONT_NAME = "Font Name";
	private final String FONT_SIZE = "Font Size";
	private final int PROPERTY_FONT_SIZE = 20;
	private final int DIALOG_WINDOW_SIZE = 600;

	private List fontFamilyList;
	private int listRows;
	private PropertyInfo tmpPropertyInfo;
	private Font propertyFont;

	private Button fontFamilyListButton;
	private Button updateButton;
	public PropertyDialog(){
		setSize(DIALOG_WINDOW_SIZE,DIALOG_WINDOW_SIZE);
		setResizable(false);

		this.listRows = 1;
		this.tmpPropertyInfo = PropertyInfo.instance.clone();

		this.propertyFont = new Font("Serif",0,PROPERTY_FONT_SIZE);
		setFont(this.propertyFont);

		//font family initialization
		this.fontFamilyList = getFontFamilyList(this.listRows);
		add(fontFamilyList);
		changeSelectFont(this.tmpPropertyInfo.getFontFamily());

		//List Button initialization
		this.fontFamilyListButton = ButtonFactory.getButton(ButtonType.PULLDOWN_LIST);
		this.fontFamilyListButton.addActionListener(this);
		add(fontFamilyListButton);

		//update Button initialization
		this.updateButton = ButtonFactory.getButton(ButtonType.PROPERTY_UPDATE);
		this.updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PropertyInfo.update(tmpPropertyInfo);
				close();
			}
		});
		add(updateButton);

	}

	@Override
	//action when pushed fontFamilyListButton
	public void actionPerformed(ActionEvent e) {
		if(listRows == 1) {
			listRows = 10;
		} else {
			listRows = 1;
		}
		repaint();
	}

	public void paint(Graphics g) {
		g.drawString(FONT_FAMILY,20,100);
		g.drawString(FONT_NAME, 20, 130);
		g.drawString(FONT_SIZE, 20, 160);

//		fontFamilyList
		Dimension d = fontFamilyList.getPreferredSize(this.listRows);
		fontFamilyList.setBounds(130, 80, d.width, d.height);

		this.fontFamilyListButton.setBounds(130+d.width+2, 80, PROPERTY_FONT_SIZE+5,PROPERTY_FONT_SIZE+5);

		int rightDown = DIALOG_WINDOW_SIZE - PROPERTY_FONT_SIZE * 2;
		this.updateButton.setBounds(rightDown,rightDown,PROPERTY_FONT_SIZE+12,PROPERTY_FONT_SIZE+5);
	}

	private List getFontFamilyList(int rows) {
		List list = new List(rows,false);

		list.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedFontFamily = e.getActionCommand();
				changeSelectFont(selectedFontFamily);
				listRows=1;
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

		//propertyInfo update
		this.tmpPropertyInfo.setFontFamily(fontFamily);

		//GUI update
		this.fontFamilyList.select(selectTarget);
		this.fontFamilyList.makeVisible(selectTarget);
		repaint();
	}
	/*
	 * getSelectedItem() : String
	 * リストで選択されている項目を返す
	 *
	 * */

}
