package gui.constructorPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstructorItem;

public class ConstructorItemPanel extends JPanel implements MouseListener{

	private ConstructorItem ci;
	public ConstructorItemPanel(ConstructorItem ci) {
		this.ci = ci;
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
		ConstructorUpdateDialog dialog = new ConstructorUpdateDialog("test",ci);
		dialog.visible();
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
