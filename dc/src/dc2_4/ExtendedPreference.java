package dc2_4;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ExtendedPreference {
	private Preferences prefs;
	private PropertyInfo propertyInfo;
	private MyFrame frame;

	private final String FONT_FAMILY = "Font Family";
	private final String FONT_SIZE = "Font Size";
	private final String CHAR_COLOR = "Character Color";
	private final String BG_COLOR = "BackGround Color";
	private final String X = "X";
	private final String Y = "Y";

	public ExtendedPreference(PropertyInfo propertyInfo,MyFrame frame) {
		this.prefs = Preferences.userNodeForPackage(this.getClass());
		this.propertyInfo = propertyInfo;
		this.frame = frame;

		propertyLoad();
		positionLoad();
	}

	public void propertyLoad() {
		String fontFamily = prefs.get(FONT_FAMILY,"serif");
		String fontSize = prefs.get(FONT_SIZE,"40");
		String charColor = prefs.get(CHAR_COLOR,"white");
		String bgColor = prefs.get(BG_COLOR,"black");

		propertyInfo.setFontFamily(fontFamily);
		propertyInfo.setFontSize(fontSize);
		propertyInfo.setCharColor(charColor);
		propertyInfo.setBGColor(bgColor);
	}
	public void positionLoad() {
		int x = prefs.getInt(X,0);
		int y = prefs.getInt(Y,0);

		frame.setBounds(x, y,propertyInfo.getClockWidth(),propertyInfo.getClockHeight());
	}

	public void propertyUpdate() {
		String fontFamily = propertyInfo.getFontFamily();
		String fontSize = propertyInfo.getFontSize()+"";
		String charColor = propertyInfo.getCharColor();
		String bgColor = propertyInfo.getBGColor();

		try {
			prefs.put(FONT_FAMILY,fontFamily);
			prefs.put(FONT_SIZE,fontSize);
			prefs.put(CHAR_COLOR,charColor);
			prefs.put(BG_COLOR,bgColor);
			prefs.flush();
		} catch (BackingStoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void positionUpdate() {
		int x = frame.getX();
		int y = frame.getY();

		try {
			prefs.putInt(X, x);
			prefs.putInt(Y, y);
			prefs.flush();
		} catch (BackingStoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void propertyReflesh() {
		propertyInfo.reflesh();
		propertyUpdate();
		propertyLoad();
	}
	public void positionReflesh() {
		try {
			prefs.putInt(X, 0);
			prefs.putInt(Y, 0);
			prefs.flush();
		} catch (BackingStoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		positionLoad();
	}

}
