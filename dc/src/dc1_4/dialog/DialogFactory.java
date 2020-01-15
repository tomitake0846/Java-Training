package dc1_4.dialog;

import java.awt.Dialog;

public class DialogFactory {

	public static Dialog getDialog(DialogType type) {
		switch(type) {
			case PROPERTY :
				return new PropertyDialog();
			default : throw new IllegalArgumentException();
		}
	}

}

