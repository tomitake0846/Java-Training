package gui.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import gui.SingleInstanceFrame;

public abstract class UpdateDialog extends JDialog{

	protected static Dimension preferredSize = new Dimension(400,200);

	public UpdateDialog(String title) {
		super(SingleInstanceFrame.FRAME,title);
		setSize(400,300);
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
}