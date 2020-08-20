package gui.MethodPanel;

import java.awt.GridLayout;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

import controller.Controller;
import controller.MethodInformation;
import gui.panels.MemberPanel;
import processing.MethodInterface;
import processing.interpret.InterpretException;

public class MethodPanel extends MemberPanel{
	private MethodInterface interpret;

	public MethodPanel(MethodInterface interpreter,Controller controller) throws InterpretException {
		super(Controller.METHOD,controller,interpreter.getMethods().length,"modifier","return Type","Method name","args");
		interpret = interpreter;
		createMethodPanel();
	}

	private void createMethodPanel() {
		Method[] methods = interpret.getMethods();
		setLayout(new GridLayout(methods.length +1 ,3));

		add(getTitlePanel());

		Arrays.sort(methods,Comparator.comparing(Method::getName));

		for(Method method : methods) {
			MethodInformation mi = new MethodInformation(method);
			add(new MethodInformationPanel(mi,getController()));
		}
	}
}
