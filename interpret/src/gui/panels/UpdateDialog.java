package gui.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import controller.Controller;

public abstract class UpdateDialog extends JDialog{

	protected static Dimension preferredSize = new Dimension(400,200);
	protected Controller controller;

	public UpdateDialog(String title,Controller controller) {
		setSize(400,300);
		this.controller = controller;
	}

	public void visible() {
		add(getStatusPanel());

		//update button and cancel button setting.
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(getUpdateButton());
		buttonPanel.add(getCancelButton());

		FlowLayout layout = new FlowLayout();
		layout.setAlignment(FlowLayout.RIGHT);
		buttonPanel.setLayout(layout);

		add(buttonPanel,BorderLayout.PAGE_END);

		setVisible(true);
	}
	protected abstract JPanel getStatusPanel();
	protected abstract JButton getUpdateButton();

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
	protected JButton getCreateInstanceButton(String className) {
		JButton button = new JButton("create");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		return button;
	}

	protected Controller getController() {
		return this.controller;
	}
}
