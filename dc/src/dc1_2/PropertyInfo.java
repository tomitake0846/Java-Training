package dc1_2;

import java.awt.Font;

//not singleton
public final class PropertyInfo implements Cloneable{

	public static PropertyInfo instance = new PropertyInfo();

	//default value
	private String fontFamily = "Serif";
	private int fontName = Font.ITALIC;
	private int fontSize = 40;

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

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public void setFontName(int fontName) {
		this.fontName = fontName;
	}
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	@Override
	public PropertyInfo clone() {
		PropertyInfo instance = new PropertyInfo();
		instance.setFontFamily(this.fontFamily);
		instance.setFontName(this.fontName);
		instance.setFontSize(this.fontSize);
		return instance;
	}

	public static void update(PropertyInfo info) {
		PropertyInfo.instance.setFontFamily(info.getFontFamily());
		PropertyInfo.instance.setFontName(info.getFontName());
		PropertyInfo.instance.setFontSize(info.getFontSize());
	}
}
