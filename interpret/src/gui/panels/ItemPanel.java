package gui.panels;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.ChangeDialog;

public class ItemPanel extends JPanel implements MouseListener{

	private JLabel[] labels;
	private String[] params;

	//field Name , method name or constructor name.
	private String itemName;
	private String modifier;
	private MemberPanel mp;

	ItemPanel(MemberPanel mp,String modifier,String itemName,String...strings) {
		this.modifier = modifier;
		this.itemName = itemName;
		this.mp = mp;

		labels = new JLabel[strings.length];
		this.params = strings;
		setLayout(new GridLayout(1,labels.length));
		setName(itemName);

		add(new JLabel(modifier));
		add(new JLabel(itemName));

		for(int i=0;i<labels.length;i++) {
			labels[i] = new JLabel(strings[i]);
			add(labels[i]);
		}
		addMouseListener(this);
	}
	public String getModifier() {
		return this.modifier;
	}
	public String getItemName() {
		return this.itemName;
	}

	public JLabel[] getlabels() {
		return this.labels;
	}
	public String[] getParams() {
		return this.params;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ChangeDialog d = new ChangeDialog("test",this,this.mp);
		d.visible();
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
