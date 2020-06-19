package gui.MethodPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.Controller;
import controller.MethodItem;
import gui.panels.ItemPanel;

public class MethodItemPanel extends ItemPanel{
	private MethodItem mi;
	private Controller controller;

	public MethodItemPanel(MethodItem mi,Controller controller) {
		this.mi = mi;
		this.controller = controller;

		setLayout(new GridLayout(1,mi.getArgs().length));
		setName(mi.getMethodName());

		add(new JLabel(mi.getModifier()));
		add(new JLabel(mi.trimPackageName(mi.getReturnType())));
		add(new JLabel(mi.trimPackageName(mi.getMethodName())));
		add(new JLabel(mi.argsToString(mi.getMethod())));
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.mi.selected();
		MethodExecuteDialog dialog = new MethodExecuteDialog("test",mi,controller);
		dialog.visible();
	}
}
