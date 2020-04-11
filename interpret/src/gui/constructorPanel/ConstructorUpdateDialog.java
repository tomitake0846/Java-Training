package gui.constructorPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.ConstructorItem;
import gui.Frame;

public class ConstructorUpdateDialog extends JDialog{

	private ConstructorItem ci;
	public ConstructorUpdateDialog(String title,ConstructorItem ci) {
		super(Frame.FRAME,title);
		this.ci = ci;
		setSize(800,600);

	}


	public void visible() {
		JTextField[] fields = ci.getTextFields();
		setLayout(new GridLayout(1,fields.length));
		add(new JLabel(""+ci.getModifier()));
		add(new JLabel(ci.getConstructorName()));
		for(JTextField field :fields) {
			add(field);
		}
		add(getUpdateButton());
		add(getCancelButton());
		setVisible(true);
	}

	private JButton getUpdateButton() {
		JButton button = new JButton("update");
		button.addActionListener(Frame.FRAME.getUpdateListener());
		return button;
	}

	private JButton getCancelButton() {
		JButton button = new JButton("cancel");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				dispose();
			}
		});
		return button;
	}
}
