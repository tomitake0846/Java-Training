package processing;

import java.lang.reflect.Field;

import javax.swing.JTextField;

public class ClassNode {
	private Field field;
	private JTextField jTextField;

	//setter
	public void setField(Field field) {
		this.field = field;
	}
	public void setJTextField(JTextField jTextField) {
		this.jTextField = jTextField;
	}

	//getter
	public Field getField() {
		return this.field;
	}
	public String getTextField() {
		return this.jTextField.getText();
	}
	public Object castToRawType(String target) {
		Class<?> clazz = this.field.getType();
		return clazz.cast(target);
	}
}
