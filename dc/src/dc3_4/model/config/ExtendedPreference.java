package dc3_4.model.config;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ExtendedPreference {
	private Preferences prefs;
	private final UserConfig config = UserConfig.getInstance();

	public ExtendedPreference() {
		this.prefs = Preferences.userNodeForPackage(this.getClass());
		loadConfig();
	}

	public void loadConfig() {
		String fontFamily = prefs.get(UserConfig.FONT_FAMILY,UserConfig.DEFAULT_FONT_FAMILY);
		String fontSize = prefs.get(UserConfig.FONT_SIZE,""+UserConfig.DEFAULT_FONT_SIZE);
		String charColor = prefs.get(UserConfig.CHAR_COLOR,UserConfig.DEFAULT_CHAR_COLOR);
		String bgColor = prefs.get(UserConfig.BG_COLOR,UserConfig.DEFAULT_BG_COLOR);
		double x = prefs.getDouble(UserConfig.X,UserConfig.DEFAULT_X);
		double y = prefs.getDouble(UserConfig.Y,UserConfig.DEFAULT_Y);

		this.config.setFontFamily(fontFamily);
		this.config.setFontSize(fontSize);
		this.config.setCharColor(charColor);
		this.config.setBGColor(bgColor);
		this.config.setX(x);
		this.config.setY(y);
	}

	public void updateConfig() {
		String fontFamily = this.config.getFontFamily();
		String fontSize = this.config.getFontSize()+"";
		String charColor = this.config.getCharColor();
		String bgColor = this.config.getBGColor();
		double x = this.config.X();
		double y = this.config.Y();

		try {
			prefs.put(UserConfig.FONT_FAMILY,fontFamily);
			prefs.put(UserConfig.FONT_SIZE,fontSize);
			prefs.put(UserConfig.CHAR_COLOR,charColor);
			prefs.put(UserConfig.BG_COLOR,bgColor);
			prefs.putDouble(UserConfig.X,x);
			prefs.putDouble(UserConfig.Y,y);
			prefs.flush();
		} catch (BackingStoreException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void propertyReflesh() {
		this.config.reflesh();
		updateConfig();
		loadConfig();
	}
}
