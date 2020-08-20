package controller.argument;

import java.awt.Component;

import javax.swing.JTextField;

public class PrimitiveArgumentItem implements ArgumentItem{
	private JTextField textField;

	public PrimitiveArgumentItem(String typeName) {
		this.textField = new JTextField(typeName);
	}

	public Object getValue() {
		return this.textField.getText();
	}

	public Component getComponent() {
		return this.textField;
	}
}
