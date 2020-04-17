package gui.FieldPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.FieldItem;
import gui.Frame;
import gui.panels.UpdateDialog;
import processing.interpret.InterpretException;

public class FieldUpdateDialog extends UpdateDialog{

	private FieldItem fi;
	public FieldUpdateDialog(String title,FieldItem fi) {
		super(title);
		this.fi = fi;
	}

	protected JPanel getStatusPanel() {
		JTextField field = fi.getTextField();
		JPanel panel = new JPanel();
		panel.setPreferredSize(UpdateDialog.preferredSize);
		//really??
		panel.setLayout(new GridLayout(1,1));

		panel.add(new JLabel(fi.getModifier()));
		panel.add(new JLabel(fi.trimPackageName(fi.getFieldName())));
		panel.add(field);

		return panel;
	}


	protected JButton getUpdateButton() {
		JButton button = new JButton("update");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message;
				try {
					Frame.controller.setField();
					message = "update success.";
					JOptionPane.showMessageDialog(Frame.FRAME,message);
					dispose();
				} catch (InterpretException exception) {
					message = "exception occurred.\n"+
							exception.getMessage() +"\n" +
							exception.getException().toString();
					JOptionPane.showMessageDialog(Frame.FRAME,message);
				}
				Frame.FRAME.repaint();
			}
		});
		return button;
	}
}
