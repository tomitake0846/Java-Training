package controller;

import java.lang.reflect.Method;

import javax.swing.JTextField;

public class MethodItem extends Item{

	private Method method;
	private static MethodItem selectedItem;
	private JTextField[] textFields;

	public MethodItem(Method method) {
		this.method = method;
		this.textFields = getArgsTextField();
	}

	private JTextField[] getArgsTextField() {
		Class<?>[] types = this.method.getParameterTypes();
		JTextField[] textFields = new JTextField[types.length];
		for(int i=0;i<textFields.length;i++) {
			textFields[i] = new JTextField(types[i].getTypeName());
		}
		return textFields;
	}

	public String getMethodName() {
		return this.method.getName();
	}

	public String getReturnType() {
		return this.method.getReturnType().toString();
	}

	public String getModifier() {
		return modifierString(this.method.getModifiers());
	}

	public Method getMethod() {
		return this.method;
	}

	public void selected() {
		MethodItem.selectedItem = this;
	}

	public static MethodItem getSelectedItem() {
		return MethodItem.selectedItem;
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

	public String argsToString(Method method) {
		StringBuilder sb = new StringBuilder("(");
		for(Class<?> param : method.getParameterTypes()) {
			String name = trimPackageName(param.getName());
			sb.append(name+",");
		}
		return sb.toString().replaceAll(",$","") + ")";
	}

}
