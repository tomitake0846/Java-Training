package dc2_4.dialog;

import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JDialog;

import dc2_4.ButtonFactory;
import dc2_4.Close;
import dc2_4.DigitalClock;

public abstract class abstractDialog extends JDialog implements Close,ComponentListener{
	abstractDialog() {
		super(DigitalClock.frame);
		setVisible(true);
		addWindowListener(ButtonFactory.getCloseButton(this));
		addComponentListener(this);
		setBackground(Color.white);
	}
	@Override
	public void close() {
		dispose();
	}
	@Override
	public void componentMoved(ComponentEvent e) {
		this.repaint();
	}
	@Override
	public void componentResized(ComponentEvent e) {
		this.repaint();
	}
	@Override
	public void componentHidden(ComponentEvent e) {}

	@Override
	public void componentShown(ComponentEvent e) {}
}