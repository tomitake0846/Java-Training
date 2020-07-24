package gui.FieldPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.Controller;
import controller.FieldInformation;
import gui.panels.ItemPanel;

public class FieldInformationPanel extends ItemPanel{

	private FieldInformation fi;
	private Controller controller;
	public FieldInformationPanel(FieldInformation fi,Controller controller) {
		this.fi = fi;
		this.controller = controller;

		//really??
		setLayout(new GridLayout(1,1));
		setName(fi.getFieldName());

		add(new JLabel(fi.getModifier()));
		add(new JLabel(fi.trimPackageName(fi.getFieldName())));
		add(new JLabel(fi.getFieldValueAsString()));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.fi.selected();
		FieldUpdateDialog dialog = new FieldUpdateDialog("test",fi,controller);
		dialog.visible();
	}

}
