package dc3_4.controller.config;

import java.util.function.Consumer;

import dc3_4.model.config.UserConfig;

public class ConfigUpdater {
	private static final UserConfig CONFIG = UserConfig.getInstance();

	public static Consumer<String> fontFamilyUpdater() {
		return s -> CONFIG.setFontFamily(s);
	}

	public static Consumer<Double> fontSizeUpdater() {
		return d -> CONFIG.setFontSize(d+"");
	}

	public static Consumer<String> charColorUpdater() {
		return s -> CONFIG.setCharColor(s);
	}

	public static Consumer<String> BGColorUpdater() {
		return s -> CONFIG.setBGColor(s);
	}

	public static Consumer<Integer> xUpdater() {
		return x -> CONFIG.setX(x);
	}

	public static Consumer<Integer> yUpdater() {
		return y -> CONFIG.setY(y);
	}

	public static Runnable reseter() {
		return () -> CONFIG.reflesh();
	}
}
