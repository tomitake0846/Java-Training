package gui.constructorPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.ConstructorItem;
import controller.Controller;
import gui.panels.ItemPanel;

public class ConstructorItemPanel extends ItemPanel{

	private ConstructorItem ci;
	private Controller controller;
	public ConstructorItemPanel(ConstructorItem ci,Controller controller) {
		this.ci = ci;
		this.controller = controller;
		setLayout(new GridLayout(1,ci.getArgs().length));
		setName(ci.getConstructorName());

		add(new JLabel(ci.getModifier()));
		add(new JLabel(ci.trimPackageName(ci.getConstructorName())));
		add(new JLabel(ci.argsToString(ci.getConstructor())));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.ci.selected();
		ConstructorUpdateDialog dialog = new ConstructorUpdateDialog("test",ci,controller);
		dialog.visible();
	}
}
