package dc3_3.model;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public final class UserConfig{

	private static final UserConfig instance = new UserConfig();

	public static final String FONT_FAMILY = "Font Family";
	public static final String FONT_SIZE = "Font Size";
	public static final String CHAR_COLOR = "Character Color";
	public static final String BG_COLOR = "BackGround Color";

	//default value
	private String fontFamily = "Serif";
	private FontPosture fontName = FontPosture.ITALIC;
	private double fontSize = 40;
	private String CharColor = "white";
	private String BGColor = "black";
	private String clockTitle = "digital clock";
	private int clockWidth = 600;
	private int clockHeight = 300;

	private UserConfig(){};
	public static final UserConfig getInstance() {
		return UserConfig.instance;
	}

	public String getFontFamily() {
		return fontFamily;
	}
	public String getFontName() {
		return fontName.name();
	}
	public double getFontSize() {
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
	public Font getFont() {
		return Font.font(fontFamily,fontName,fontSize);
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public void setFontName(String fontName) {
		this.fontName = FontPosture.valueOf(fontName);
	}
	public void setFontSize(String fontSize) {
		this.fontSize = Integer.parseInt(fontSize);
		this.clockWidth = (int) (this.fontSize * 15);
		this.clockHeight = (this.clockWidth / 2) - 20;
	}
	public void setCharColor(String newCharColor){
		this.CharColor = newCharColor;
	}
	public void setBGColor(String newBGColor) {
		this.BGColor = newBGColor;
	}


	public static Color toColor(String color) {
		return Color.valueOf(color);
	}

	public String getCurrentProperty(String propertyName) {
		switch(propertyName) {
		case FONT_FAMILY : return getFontFamily();
		case FONT_SIZE : return ""+getFontSize();
		case CHAR_COLOR : return getCharColor();
		case BG_COLOR : return getBGColor();
		default : throw new IllegalArgumentException();
		}
	}

	public void reflesh() {
		fontFamily = "Serif";
		fontName = FontPosture.ITALIC;
		fontSize = 40;
		CharColor = "white";
		BGColor = "black";
		clockTitle = "Digital Clock";
		clockWidth = 600;
		clockHeight = 300;
	}
}
