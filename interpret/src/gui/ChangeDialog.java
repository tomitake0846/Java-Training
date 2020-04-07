package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.panels.ItemPanel;
import gui.panels.MemberPanel;
import processing.interpret.InterpretException;

public class ChangeDialog extends JDialog{

	private ItemPanel itemPanel;
	private MemberPanel mp;

	public ChangeDialog(String title,ItemPanel itemPanel,MemberPanel mp) {
		super(Frame.FRAME,title);
		this.itemPanel = itemPanel;
		this.mp = mp;
		setSize(800,600);
	}

	public void visible() {
		add(mp.getTitlePanel());
		String[] params = itemPanel.getParams();

		setLayout(new GridLayout(1,params.length));
		add(new JLabel(itemPanel.getModifier()));
		add(new JLabel(itemPanel.getItemName()));
		for(String str : params) {
			add(new JTextField(str));
		}
		add(getUpdateButton());
		add(getCancelButton());
		setVisible(true);
	}

	private JButton getUpdateButton() {
		JButton button = new JButton("update");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動生成されたメソッド・スタブ
				String message;
				try {
					mp.update(itemPanel);
					message = "update success.";
				} catch(InterpretException exception) {
					message = "exception occurred.\n"+
							  exception.getMessage() +"\n" +
							  exception.getException().toString();
				}
				JOptionPane.showMessageDialog(mp,message);
				mp.repaint();
				dispose();
			}
		});
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
