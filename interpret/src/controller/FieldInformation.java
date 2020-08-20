package controller;

import java.lang.reflect.Field;

public class FieldInformation extends MemberInformation{

	private Field field;
	private static FieldInformation selectedItem;
	private String fieldValue;

	public FieldInformation(Field field,String fieldValue) {
		super(field.getType());
		this.field = field;
		this.fieldValue = fieldValue;
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

	public static FieldInformation getSelectedItem() {
		return FieldInformation.selectedItem;
	}

	public void selected() {
		FieldInformation.selectedItem = this;
	}

}
