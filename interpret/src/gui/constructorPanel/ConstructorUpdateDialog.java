package gui.constructorPanel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ConstructorInformation;
import controller.Controller;
import controller.argument.ArgumentItem;
import gui.panels.UpdateDialog;
import processing.interpret.InterpretException;

public class ConstructorUpdateDialog extends UpdateDialog{

	private ConstructorInformation ci;
	public ConstructorUpdateDialog(String title,ConstructorInformation ci,Controller controller) {
		super(title,controller);
		this.ci = ci;
	}

	protected JPanel getStatusPanel() {
		ArgumentItem[] items = ci.getArgumentItems();
		JPanel panel = new JPanel();
		panel.setPreferredSize(UpdateDialog.preferredSize);
		panel.setLayout(new GridLayout(1,items.length));
		panel.add(new JLabel(ci.getModifier()));
		panel.add(new JLabel(ci.trimPackageName(ci.getConstructorName())));
		for(ArgumentItem item :items) {
			panel.add(item.getComponent());
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
					c.createInstance();
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
