package gui.panels;

import java.awt.GridLayout;
import java.lang.reflect.Method;

import processing.MethodInterface;
import processing.interpret.InterpretException;

public class MethodPanel extends MemberPanel{
	private MethodInterface interpret;

	public MethodPanel(MethodInterface interpreter) throws InterpretException {
		super("modifier","field name","args");
		interpret = interpreter;
		createMethodPanel();
	}

	private void createMethodPanel() {
		Method[] methods = interpret.getMethods();
		setLayout(new GridLayout(methods.length +1 ,3));

		add(getTitlePanel());
		for(Method method : methods) {
			String methodName = method.getName();
			String modifier = modifierString(method.getModifiers());
			add(new ItemPanel(this,modifier,methodName,args(method)));
		}
	}
	private String args(Method method) {
		StringBuilder sb = new StringBuilder("(");
		for(Class<?> param : method.getParameterTypes()) {
			sb.append(param.getName()+",");
		}
		return sb.toString().replaceAll(",$","") + ")";
	}
	@Override
	public void update(ItemPanel itemPanel) throws InterpretException {

		System.out.println("Clicked!");
		throw new InterpretException("error occurred.",new Exception());

	}
}
