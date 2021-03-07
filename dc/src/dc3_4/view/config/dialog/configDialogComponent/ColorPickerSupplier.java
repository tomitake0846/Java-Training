package dc3_4.view.config.dialog.configDialogComponent;

import java.util.function.Consumer;

import dc3_4.controller.config.ConfigUpdater;
import dc3_4.model.config.UserConfig;
import javafx.scene.control.ColorPicker;

public class ColorPickerSupplier {
	private static MyColorPicker charColorPicker;
	private static MyColorPicker BGColorPicker;
	private static final UserConfig config = UserConfig.getInstance();

	public static ColorPicker getCharColorPicker() {
		if( charColorPicker == null ) {
			charColorPicker = getBaseColorPicker(
					config.getCharColor(),
					ConfigUpdater.charColorUpdater());
		}
		return charColorPicker;
	}

	public static ColorPicker getBGColorPicker() {
		if( BGColorPicker == null ) {
			BGColorPicker = getBaseColorPicker(
					config.getBGColor(),
					ConfigUpdater.BGColorUpdater());
		}
		return BGColorPicker;
	}

	public static void update() {
		charColorPicker.activateUpdateEvent();
		BGColorPicker.activateUpdateEvent();
	}

	private static MyColorPicker getBaseColorPicker(String defaultValue,Consumer<String> c) {
		MyColorPicker cp = new MyColorPicker();
		cp.setUpdater(c);
		cp.setValue(UserConfig.toColor(defaultValue));
		return cp;
	}

	private static class MyColorPicker extends ColorPicker{
		private Consumer<String> updateEvent;
		private void setUpdater(Consumer<String> updateEvent) {
			this.updateEvent = updateEvent;
		}
		private void activateUpdateEvent() {
			this.updateEvent.accept(getValue().toString());
		}
	}
}
