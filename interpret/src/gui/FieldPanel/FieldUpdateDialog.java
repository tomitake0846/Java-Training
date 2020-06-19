package gui.FieldPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import controller.FieldItem;
import gui.panels.UpdateDialog;
import processing.interpret.InterpretException;

public class FieldUpdateDialog extends UpdateDialog{

	private FieldItem fi;
	public FieldUpdateDialog(String title,FieldItem fi,Controller controller) {
		super(title,controller);
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
		Controller c = getController();

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String message;
				try {
					c.setField();
					message = "update success.";
					JOptionPane.showMessageDialog(null,message);
					dispose();
				} catch (InterpretException exception) {
					message = "exception occurred.\n"+
							exception.getMessage() +"\n" +
							exception.getException().toString();
					JOptionPane.showMessageDialog(null,message);
				}
				c.getManagedFrame().repaint();
			}
		});
		return button;
	}
}
