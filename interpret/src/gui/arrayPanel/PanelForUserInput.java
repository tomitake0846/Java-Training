package gui.arrayPanel;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelForUserInput extends JPanel{

	private JTextField typeTextField;
	private JTextField sizeTextField;

	public PanelForUserInput(ActionListener listener) {
		add(getTypePanel());
		add(getSizePanel());
		add(getUpdateButton(listener));
		setSize(1200, 100);
	}

	public String getTypeField() {
		return this.typeTextField.getText();
	}

	public String getSizeField() {
		return this.sizeTextField.getText();
	}

	private JPanel getTypePanel () {
		JPanel panel = new JPanel();

		JLabel label = new JLabel("Type :");
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(250,30));

		panel.add(label);
		panel.add(text);
		typeTextField = text;

		return panel;
	}

	private JPanel getSizePanel () {

		JPanel panel = new JPanel();

		JLabel label = new JLabel("Size :");
		JTextField text = new JTextField();
		text.setPreferredSize(new Dimension(250,30));

		panel.add(label);
		panel.add(text);
		sizeTextField = text;

		return panel;
	}

	private JButton getUpdateButton(ActionListener listener) {
		JButton button = new JButton("update");
		button.addActionListener(listener);
		return button;
	}
}
