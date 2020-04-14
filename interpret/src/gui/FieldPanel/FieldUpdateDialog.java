package gui.FieldPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.FieldItem;
import gui.Frame;
import processing.interpret.InterpretException;

public class FieldUpdateDialog extends JDialog{

	private FieldItem fi;
	public FieldUpdateDialog(String title,FieldItem fi) {
		this.fi = fi;
		setSize(800,600);
	}

	public void visible() {
		JTextField field = fi.getTextField();

		//really??
		setLayout(new GridLayout(1,1));

		add(new JLabel(fi.getModifier()));
		add(new JLabel(fi.trimPackageName(fi.getFieldName())));
		add(field);

		add(getUpdateButton());
		add(getCancelButton());
		setVisible(true);
	}

	private JButton getUpdateButton() {
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

	private JButton getCancelButton() {
		JButton button = new JButton("cancel");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		return button;
	}
}
