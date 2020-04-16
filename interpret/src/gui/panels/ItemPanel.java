package gui.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public abstract class ItemPanel extends JPanel implements MouseListener{

	public ItemPanel() {
		this.setPreferredSize(new Dimension(1200,40));
		this.setBorder(new LineBorder(Color.black,1,true));
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
