package controller;

import java.lang.reflect.Constructor;

import controller.argument.ArgumentItem;

public class ConstructorInformation extends MemberInformation{

	private Constructor<?> constructor;
	private static ConstructorInformation selectedItem;

	public ConstructorInformation(Constructor<?> constructor) {
		super(constructor.getParameterTypes());
		this.constructor = constructor;
	}

	public String getModifier() {
		return modifierString(this.constructor.getModifiers());
	}

	public String getConstructorName() {
		return this.constructor.getName();
	}

	public Constructor<?> getConstructor() {
		return this.constructor;
	}

	public void selected() {
		ConstructorInformation.selectedItem = this;
	}

	public static ConstructorInformation getSelectedItem() {
		return ConstructorInformation.selectedItem;
	}

	public Object[] getArgs() {
		ArgumentItem[] ais = getArgumentItems();
		Object[] args = new Object[ais.length];

		for(int i=0;i<args.length;i++) {
			args[i] = ais[i].getValue();
		}
		return args;
	}

	public String argsToString(Constructor<?> constructor) {
		StringBuilder sb = new StringBuilder("(");
		for(Class<?> param : constructor.getParameterTypes()) {
			String name = trimPackageName(param.getName());
			sb.append(name+",");
		}
		return sb.toString().replaceAll(",$","") + ")";
	}
}
