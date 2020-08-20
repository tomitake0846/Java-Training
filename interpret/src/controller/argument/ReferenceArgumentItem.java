package controller.argument;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

import gui.SingleInstanceFrame;

public class ReferenceArgumentItem implements ArgumentItem{
	private String typeName;
	private Object instance;
	public ReferenceArgumentItem(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public Object getValue() {
		return instance;
	}
	@Override
	public Component getComponent() {
		return getCreateInstanceButton();
	}

	private JButton getCreateInstanceButton() {
		JButton button = new JButton("create　"+typeName+" object.");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SingleInstanceFrame sif = new SingleInstanceFrame();
				sif.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						instance = sif.getInstance();
						sif.dispose();
					}
				});
				sif.setText(typeName);
				sif.setVisible(true);
			}
		});
		return button;
	}

}
