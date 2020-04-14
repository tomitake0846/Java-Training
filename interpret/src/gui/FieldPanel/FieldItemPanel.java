package gui.FieldPanel;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.FieldItem;

public class FieldItemPanel extends JPanel implements MouseListener{

	private FieldItem fi;
	public FieldItemPanel(FieldItem fi) {
		this.fi = fi;

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
		FieldUpdateDialog dialog = new FieldUpdateDialog("test",fi);
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
