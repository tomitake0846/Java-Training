package dc1_4.dialog;

import java.awt.Dialog;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import dc1_4.ButtonFactory;
import dc1_4.Close;
import dc1_4.DigitalClock;

public abstract class abstractDialog extends Dialog implements Close,ComponentListener{
	abstractDialog() {
		super(DigitalClock.frame);
		setVisible(true);
		addWindowListener(ButtonFactory.getCloseButton(this));
		addComponentListener(this);
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