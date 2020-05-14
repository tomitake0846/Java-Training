package dc2_2;

import java.applet.Applet;
import java.awt.Dimension;

import javax.swing.JComboBox;

public class PulldownList extends Applet{

	private JComboBox<String> combo;
	private int x;
	private int y;

	public PulldownList(String[] listItems,String selectedItem,int x,int y) {
		combo = new JComboBox<String>(listItems);
		combo.setPreferredSize(new Dimension(x,30));
		combo.setSelectedItem(selectedItem);
		setVisible(true);
		this.x = x;
		this.y = y;
	}

	public void paintPrepare() {
		Dimension d = this.combo.getPreferredSize();
		this.combo.setBounds(getX(), getY(), d.width, d.height);
	}

	public JComboBox<String> getComboBox() {
		return this.combo;
	}
	public String getSelectedItem() {
		return (String)this.combo.getSelectedItem();
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
}
