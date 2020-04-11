package controller;

import java.util.HashMap;
import java.util.Map;

import gui.constructorPanel.ConstructorPanel;
import gui.panels.FieldPanel;
import gui.panels.MemberPanel;
import gui.panels.MethodPanel;
import processing.InterpreterFacade;
import processing.interpret.InterpretException;

public class Controller {

	public static final String CONSTRUCTOR = "Constructor";
	public static final String FIELD = "Field";
	public static final String METHOD = "Method";

	private InterpreterFacade interpreter;
	private Map<String,MemberPanel> panelMap;

	public Controller() {
		this.panelMap = new HashMap<String,MemberPanel>();
	}

	// create constructorPanel , panel that display constructor list , and return it.
	public MemberPanel getDisplayPanel(String command,String className) throws InterpretException {
		if(Controller.CONSTRUCTOR.equals(command)) {

			this.interpreter = new InterpreterFacade(className);
			ConstructorPanel cp = new ConstructorPanel(interpreter);
			panelMap.put(CONSTRUCTOR,cp);

			return cp;

		} else {
			throw new UnsupportedOperationException();
		}
	}

	public MemberPanel getDisplayPanel(String command) throws InterpretException {
		return panelMap.get(command);
	}

	public boolean hasInstance() {
		if(interpreter == null) {
			return false;
		}
		return interpreter.hasInstance();
	}

	public void createInstance() throws InterpretException {

		ConstructorItem ci = ConstructorItem.getSelectedItem();

		// how input Constructor<?> that in Constrcutor ItemPanel ?
		this.interpreter.Construct(ci.getConstructor(),ci.getArgs());

		panelMap.put(Controller.FIELD,new FieldPanel(interpreter));

		panelMap.put(Controller.METHOD,new MethodPanel(interpreter));

	}

}
