package gui.constructorPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ConstructorItem;
import gui.SingleInstanceFrame;
import gui.panels.UpdateDialog;
import processing.interpret.InterpretException;

public class ConstructorUpdateDialog extends UpdateDialog{

	private ConstructorItem ci;
	public ConstructorUpdateDialog(String title,ConstructorItem ci) {
		super(title);
		this.ci = ci;
	}

	protected JPanel getStatusPanel() {
		JTextField[] fields = ci.getTextFields();
		JPanel panel = new JPanel();
		panel.setPreferredSize(UpdateDialog.preferredSize);
		panel.setLayout(new GridLayout(1,fields.length));
		panel.add(new JLabel(ci.getModifier()));
		panel.add(new JLabel(ci.trimPackageName(ci.getConstructorName())));
		for(JTextField field :fields) {
			panel.add(field);
		}
		return panel;
	}

	protected JButton getUpdateButton() {
		JButton button = new JButton("update");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message;
				try {
					SingleInstanceFrame.controller.createInstance();
					message = "update success.";
					JOptionPane.showMessageDialog(SingleInstanceFrame.FRAME,message);
					dispose();
				} catch (InterpretException exception) {
					message = "exception occurred.\n"+
							exception.getMessage() +"\n" +
							exception.getException().toString();
					JOptionPane.showMessageDialog(SingleInstanceFrame.FRAME,message);
				}
				SingleInstanceFrame.FRAME.repaint();
			}
		});
		return button;
	}
}
