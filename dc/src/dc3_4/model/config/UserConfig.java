package dc3_4.model.config;


import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

import dc3_4.model.utils.JsonProcessor;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public final class UserConfig{

	private static final UserConfig instance = new UserConfig();

	public static final String FONT_FAMILY = "Font Family";
	public static final String FONT_NAME = "Font Name";
	public static final String FONT_SIZE = "Font Size";
	public static final String CHAR_COLOR = "Character Color";
	public static final String BG_COLOR = "BackGround Color";
	public static final String X = "X coordinate";
	public static final String Y = "Y coordinate";

	//default value
	public static final String DEFAULT_FONT_FAMILY = "Serif";
	public static final FontPosture DEFAULT_FONT_NAME = FontPosture.ITALIC;
	public static final double DEFAULT_FONT_SIZE = 40;
	public static final String DEFAULT_CHAR_COLOR = "white";
	public static final String DEFAULT_BG_COLOR = "black";
	public static final String DEFAULT_CLOCK_TITLE = "digital clock";
	public static final int DEFAULT_CLOCK_WITDH = 600;
	public static final int DEFAULT_CLOCK_HEIGHT = 300;
	public static final double DEFAULT_X = 200;
	public static final double DEFAULT_Y = 200;

	private String fontFamily;
	private FontPosture fontName;
	private double fontSize;
	private String CharColor;
	private String BGColor;
	private String clockTitle;
	private int clockWidth;
	private int clockHeight;
	private double x;
	private double y;

	private UserConfig(){
		reflesh();
	};
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
	public double X() {
		return this.x;
	}
	public double Y() {
		return this.y;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public void setFontName(String fontName) {
		this.fontName = FontPosture.valueOf(fontName);
	}
	public void setFontSize(String fontSize) {
		this.fontSize = Double.parseDouble(fontSize);
		this.clockWidth = (int) (this.fontSize * 15);
		this.clockHeight = (this.clockWidth / 2) - 20;
	}
	public void setCharColor(String newCharColor){
		this.CharColor = newCharColor;
	}
	public void setBGColor(String newBGColor) {
		this.BGColor = newBGColor;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
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
		fontFamily = UserConfig.DEFAULT_FONT_FAMILY;
		fontName = UserConfig.DEFAULT_FONT_NAME;
		fontSize = UserConfig.DEFAULT_FONT_SIZE;
		CharColor = UserConfig.DEFAULT_CHAR_COLOR;
		BGColor = UserConfig.DEFAULT_BG_COLOR;
		clockTitle = UserConfig.DEFAULT_CLOCK_TITLE;
		clockWidth = UserConfig.DEFAULT_CLOCK_WITDH;
		clockHeight = UserConfig.DEFAULT_CLOCK_HEIGHT;
		x = UserConfig.DEFAULT_X;
		y = UserConfig.DEFAULT_Y;
	}

	public String toJson() throws JsonProcessingException {
		Map<String,String> map = new HashMap<>();
		map.put(FONT_FAMILY, getFontFamily());
		map.put(FONT_NAME, getFontName());
		map.put(FONT_SIZE, ""+getFontSize());
		map.put(CHAR_COLOR, getCharColor());
		map.put(BG_COLOR, getBGColor());
		map.put(X, ""+X());
		map.put(Y, ""+Y());
		return JsonProcessor.toJsonFormat(map);
	}

	public void loadFromJson(String json) {
		Map<String,String> config = null;
		try {
			config = JsonProcessor.jsonToMap(json);
			setFontFamily(config.get(FONT_FAMILY));
			setFontName(config.get(FONT_NAME));
			setFontSize(config.get(FONT_SIZE));
			setCharColor(config.get(CHAR_COLOR));
			setBGColor(config.get(BG_COLOR));
			setX(Double.parseDouble(config.get(X)));
			setY(Double.parseDouble(config.get(Y)));
		} catch (JsonProcessingException e) {
			System.err.println(e.getMessage());
			throw new IllegalStateException("failed json parse :"+json);
		} catch (NumberFormatException e) {
			throw new IllegalStateException("X:"+config.get(X)+ " or Y:" + config.get(Y) +"are not a number.");
		}
	}
}