package dc1_4;

import java.awt.Color;
import java.awt.Font;
import java.lang.reflect.Field;

public final class PropertyInfo{

	public static PropertyInfo instance = new PropertyInfo();

	//default value
	private String fontFamily = "Serif";
	private int fontName = Font.ITALIC;
	private int fontSize = 40;
	private String CharColor = "white";
	private String BGColor = "black";
	private String clockTitle = "digital clock";
	private int clockWidth = 600;
	private int clockHeight = 300;

	private PropertyInfo(){};

	public String getFontFamily() {
		return fontFamily;
	}
	public int getFontName() {
		return fontName;
	}
	public int getFontSize() {
		return fontSize;
	}
	public String getCharColor() {
		return this.CharColor;
	}
	public String getBGColor() {
		return this.BGColor;
	}
	public int getClockWidth() {
		return this.clockWidth;
	}

	public int getClockHeight() {
		return this.clockHeight;
	}
	public String getClockTitle() {
		return this.clockTitle;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public void setFontName(int fontName) {
		this.fontName = fontName;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = Integer.parseInt(fontSize);
		this.clockWidth = this.fontSize * 15;
		this.clockHeight = (this.clockWidth / 2) - 20;
	}
	public void setCharColor(String newCharColor){
		this.CharColor = newCharColor;
	}
	public void setBGColor(String newBGColor) {
		this.BGColor = newBGColor;
	}

	public static Color toColor(String color) {
		try {
			Class<Color> c = Color.class;
			Field field = c.getDeclaredField(color);
			return (Color) field.get(Color.BLACK);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
