package gui.MethodPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import controller.Controller;
import controller.MethodInformation;
import gui.panels.ItemPanel;

public class MethodInformationPanel extends ItemPanel{
	private MethodInformation mi;
	private Controller controller;

	public MethodInformationPanel(MethodInformation mi,Controller controller) {
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
