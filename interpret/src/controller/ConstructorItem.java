package controller;

import java.lang.reflect.Constructor;

import javax.swing.JTextField;

public class ConstructorItem {

	private Constructor<?> constructor;
	private static ConstructorItem selectedItem;
	private JTextField[] textFields;

	public ConstructorItem(Constructor<?> constructor) {
		this.constructor = constructor;
		this.textFields = getArgsTextField();
	}

	public int getModifier() {
		return this.constructor.getModifiers();
	}

	public String getConstructorName() {
		return this.constructor.getName();
	}

	public Constructor<?> getConstructor() {
		return this.constructor;
	}

	public void selected() {
		selectedItem = this;
	}

	public static ConstructorItem getSelectedItem() {
		return ConstructorItem.selectedItem;
	}
	public String[] getArgs() {
		String[] args = new String[this.textFields.length];
		for(int i=0;i<args.length;i++) {
			args[i] = textFields[i].getText();
		}
		return args;
	}

	public JTextField[] getTextFields() {
		return this.textFields;
	}

	private JTextField[] getArgsTextField() {
		Class<?>[] types = this.constructor.getParameterTypes();
		JTextField[] textFields = new JTextField[types.length];
		for(int i=0;i<textFields.length;i++) {
			textFields[i] = new JTextField(types[i].getTypeName());
		}
		return textFields;
	}
}
