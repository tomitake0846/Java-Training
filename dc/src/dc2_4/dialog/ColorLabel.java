package dc2_4.dialog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import dc2_4.PropertyInfo;

// element in ComboBox
public class ColorLabel {
	private String color;
	Icon colorChip;
	private final int COLOR_CHIP_SIZE=12;

	//only in package
	ColorLabel(String color) {

		//set color name
		this.color = color;

		//create and set icon
		Color c = PropertyInfo.toColor(color);
		BufferedImage i = new BufferedImage(COLOR_CHIP_SIZE,COLOR_CHIP_SIZE,BufferedImage.TYPE_INT_RGB);
		Graphics g = i.getGraphics();
		g.setColor(c);
		g.fillRect(0,0,COLOR_CHIP_SIZE,COLOR_CHIP_SIZE);
		colorChip = new ImageIcon(i);
	}
	public String getColorName() {
		return color;
	}
	public Icon getColorChip() {
		return colorChip;
	}
}

