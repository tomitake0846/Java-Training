package gui.MethodPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.MethodItem;
import gui.Frame;
import processing.interpret.InterpretException;

public class MethodExecuteDialog extends JDialog{
	private MethodItem mi;
	public MethodExecuteDialog(String title, MethodItem mi) {
		super(Frame.FRAME,title);
		this.mi = mi;
		setSize(800,600);
	}

	public void visible() {
		JTextField[] fields = mi.getTextFields();
		setLayout(new GridLayout(1,fields.length));
		add(new JLabel(mi.getModifier()));
		add(new JLabel(mi.trimPackageName(mi.getMethodName())));
		for(JTextField field :fields) {
			add(field);
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
				String message;
				try {
					Object returnVal = Frame.controller.executeMethod();
					message = "execute success.";

					if(returnVal != null) {
						message += "\nreturn :"+returnVal.toString();
					}

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
