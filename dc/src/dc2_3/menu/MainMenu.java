package dc2_3.menu;

import java.awt.Dialog;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dc2_3.dialog.DialogFactory;
import dc2_3.dialog.DialogType;

public class MainMenu extends Menu implements ActionListener{

	public MainMenu() {
		super("menu");

		//init property menu item.
		MenuItem property = new MenuItem("property");
		property.addActionListener(this);
		add(property);

	}

	public void actionPerformed(ActionEvent e) {
		Dialog dialog= null;
		switch ( e.getActionCommand() ) {
		    case "property":
		    	dialog = DialogFactory.getDialog(DialogType.PROPERTY);
		    	break;
		}
//		while(true) {
//			dialog.repaint();
//		}
	}
}
