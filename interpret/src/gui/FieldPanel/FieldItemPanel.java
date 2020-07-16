package gui.FieldPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.Controller;
import controller.FieldItem;
import gui.panels.ItemPanel;

public class FieldItemPanel extends ItemPanel{

	private FieldItem fi;
	private Controller controller;
	public FieldItemPanel(FieldItem fi,Controller controller) {
		this.fi = fi;
		this.controller = controller;

		//really??
		setLayout(new GridLayout(1,1));
		setName(fi.getFieldName());

		add(new JLabel(fi.getModifier()));
		add(new JLabel(fi.trimPackageName(fi.getFieldName())));
		System.out.println(fi.getFieldValueAsString());
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
