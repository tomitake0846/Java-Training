
package gui.MethodPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;
import controller.MethodItem;
import gui.panels.UpdateDialog;
import processing.interpret.InterpretException;

public class MethodExecuteDialog extends UpdateDialog{
	private MethodItem mi;
	public MethodExecuteDialog(String title, MethodItem mi,Controller controller) {
		super(title,controller);
		this.mi = mi;
	}

	protected JPanel getStatusPanel() {
		JTextField[] fields = mi.getTextFields();
		JPanel panel = new JPanel();
		panel.setPreferredSize(UpdateDialog.preferredSize);
		panel.setLayout(new GridLayout(1,fields.length));
		panel.add(new JLabel(mi.getModifier()));
		panel.add(new JLabel(mi.trimPackageName(mi.getMethodName())));
		for(JTextField field :fields) {
			panel.add(field);
		}
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
					Object returnVal = c.executeMethod();
					message = "execute success.";

					if(returnVal != null) {
						message += "\nreturn :"+returnVal.toString();
					}

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
