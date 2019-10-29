package dc1_2;

import java.awt.Font;

public final class PropertyInfo {

	public static PropertyInfo instance = new PropertyInfo();

	private String fontFamily = "Serif";
	private int fontName = Font.ITALIC;
	private int fontSize = 40;

	public String getFontFamily() {
		return fontFamily;
	}
	public int getFontName() {
		return fontName;
	}
	public int getFontSize() {
		return fontSize;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public void setFontName(int fontName) {
		this.fontName = fontName;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
}
