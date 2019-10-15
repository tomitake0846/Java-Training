package dc1_2;

import java.awt.Dialog;

public class DialogFactory {
	public static Dialog getDialog(DialogType type) {
		switch(type) {
			case PROPERTY : return null;
			default : throw new IllegalArgumentException();
		}
	}
}
