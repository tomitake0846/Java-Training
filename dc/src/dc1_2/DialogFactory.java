package dc1_2;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class DialogFactory {

	public static Dialog getDialog(DialogType type) {
		switch(type) {
			case PROPERTY :
				return getPropertyDialog();
			default : throw new IllegalArgumentException();
		}
	}
	private static Dialog getPropertyDialog() {
		return new abstractDialog() {
			List fontFamilyList;
			{
				setSize(400,400);
				fontFamilyList = getFontFamilyList(1);
				add(fontFamilyList);
			}
			public void paint(Graphics g) {
				g.drawString("Font Family",20,100);
				g.drawString("Font Name", 20, 130);
				g.drawString("Font Size", 20, 160);
				Dimension d = fontFamilyList.getPreferredSize();
				fontFamilyList.setBounds(120, 100, d.width, d.height);
			}
			public List getFontFamilyList(int rows) {
				List list = new List(rows);
				for(String name : GraphicsEnvironment.getLocalGraphicsEnvironment()
						                             .getAvailableFontFamilyNames()) {
					list.add(name);
				}
				return list;
			}
		};
	}

	private static abstract class abstractDialog extends Dialog implements Close,ComponentListener{
		private abstractDialog() {
			super(DigitalClock.frame);
			setVisible(true);
			addWindowListener(ButtonFactory.getCloseButton(this));
			addComponentListener(this);
		}
		public void close() {
			dispose();
		}
		@Override
		public void componentMoved(ComponentEvent e) {
			this.repaint();
			System.out.println("moved");
		}
		@Override
		public void componentResized(ComponentEvent e) {
			this.repaint();
			System.out.println("resized");
		}
		@Override
		public void componentHidden(ComponentEvent e) {}

		@Override
		public void componentShown(ComponentEvent e) {}
	}
}

