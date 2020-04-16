package gui.MethodPanel;

import java.awt.GridLayout;
import java.lang.reflect.Method;

import controller.MethodItem;
import gui.panels.MemberPanel;
import processing.MethodInterface;
import processing.interpret.InterpretException;

public class MethodPanel extends MemberPanel{
	private MethodInterface interpret;

	public MethodPanel(MethodInterface interpreter) throws InterpretException {
		super(interpreter.getMethods().length,"modifier","return Type","Method name","args");
		interpret = interpreter;
		createMethodPanel();
	}

	private void createMethodPanel() {
		Method[] methods = interpret.getMethods();
		setLayout(new GridLayout(methods.length +1 ,3));

		add(getTitlePanel());
		for(Method method : methods) {
			MethodItem mi = new MethodItem(method);
			add(new MethodItemPanel(mi));
		}
	}
}
