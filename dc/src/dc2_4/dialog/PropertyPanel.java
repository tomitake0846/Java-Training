package dc2_4.dialog;

import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dc2_4.PropertyInfo;

public class PropertyPanel extends JPanel{

	private JComboBox<String> FontFamilyBox;
	private JComboBox<String> FontSizeBox;
	private ColorComboBox<ColorLabel> CharColorBox;
	private ColorComboBox<ColorLabel> BGColorBox;

	private PropertyInfo propertyInfo = PropertyInfo.instance;

	public PropertyPanel() {
		String[] fontFamilyList = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getAvailableFontFamilyNames();
		String[] fontSizeList = {"20","26","32","40","48","56"};
		String[] colorList = {"white","lightGray","gray","darkGray","black","red",
				"pink","orange","yellow","green","magenta","cyan","blue"};

		this.FontFamilyBox = new JComboBox<String>(fontFamilyList);
		this.FontSizeBox = new JComboBox<String>(fontSizeList);
		this.CharColorBox = ColorComboBox.getColorComboBox(colorList);
		this.BGColorBox = ColorComboBox.getColorComboBox(colorList);

		initPanel();

	}

	//getter
	public String getSelectedFontFamily() {
		return (String)this.FontFamilyBox.getSelectedItem();
	}
	public String getSelectedFontSize() {
		return (String)this.FontSizeBox.getSelectedItem();
	}
	public String getSelectedCharColor() {
		return this.CharColorBox.getSelectedColorItem();
	}
	public String getSelectedBGColor() {
		return this.BGColorBox.getSelectedColorItem();
	}

	private void initPanel() {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		this.setLayout(layout);

		setProperties(layout,gbc,0,PropertyInfo.FONT_FAMILY,this.FontFamilyBox);
		setProperties(layout,gbc,1,PropertyInfo.FONT_SIZE,this.FontSizeBox);
		setProperties(layout,gbc,2,PropertyInfo.CHAR_COLOR,this.CharColorBox);
		setProperties(layout,gbc,3,PropertyInfo.BG_COLOR,this.BGColorBox);
	}

	private void setProperties(GridBagLayout layout,GridBagConstraints gbc,int y,String propertyName,JComboBox<? extends Object> box) {
		//set label
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.anchor = GridBagConstraints.EAST;
		JLabel label = new JLabel(propertyName);
		layout.setConstraints(label, gbc);
		this.add(label);

		//set pulldown list
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;

		if(box instanceof ColorComboBox) {
			((ColorComboBox) box).setSelectedColorItem(this.propertyInfo.getCurrentProperty(propertyName));
		} else {
			box.setSelectedItem(this.propertyInfo.getCurrentProperty(propertyName));
		}
		layout.setConstraints(box,gbc);
		this.add(box);
	}
}
