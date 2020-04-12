package gui.MethodPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MethodItem;

public class MethodItemPanel extends JPanel implements MouseListener{
	private MethodItem mi;

	public MethodItemPanel(MethodItem mi) {
		this.mi = mi;

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
		MethodExecuteDialog dialog = new MethodExecuteDialog("test",mi);
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
