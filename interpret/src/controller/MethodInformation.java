package controller;

import java.lang.reflect.Method;

import controller.argument.ArgumentItem;

public class MethodInformation extends MemberInformation{

	private Method method;
	private static MethodInformation selectedItem;

	public MethodInformation(Method method) {
		super(method.getParameterTypes());
		this.method = method;
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
		MethodInformation.selectedItem = this;
	}

	public static MethodInformation getSelectedItem() {
		return MethodInformation.selectedItem;
	}

	public Object[] getArgs() {
		ArgumentItem[] ais = getArgumentItems();
		Object[] args = new Object[ais.length];

		for(int i=0;i<args.length;i++) {
			args[i] = ais[i].getValue();
		}
		return args;
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
