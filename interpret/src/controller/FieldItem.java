package controller;

import java.lang.reflect.Field;

import javax.swing.JTextField;

public class FieldItem extends Item{

	private Field field;
	private static FieldItem selectedItem;
	private JTextField textField;
	private String fieldValue;

	public FieldItem(Field field,String fieldValue) {
		this.field = field;
		this.textField = getInitialTextField();
		this.fieldValue = fieldValue;
	}

	private JTextField getInitialTextField() {
		JTextField textField = new JTextField(trimPackageName(getFieldType()));
		return textField;
	}

	public String getFieldName() {
		return this.field.getName();
	}

	public String getFieldType() {
		return this.field.getType().toString();
	}
	public String getFieldValueAsString() {
		return this.fieldValue;
	}

	public String getModifier() {
		return modifierString(this.field.getModifiers());
	}

	public Field getField() {
		return this.field;
	}

	public static FieldItem getSelectedItem() {
		return FieldItem.selectedItem;
	}

	public void selected() {
		FieldItem.selectedItem = this;
	}

	public JTextField getTextField() {
		return this.textField;
	}

}
