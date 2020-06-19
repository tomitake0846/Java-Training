package controller;

import java.util.HashMap;
import java.util.Map;

import gui.SingleInstanceFrame;
import gui.FieldPanel.FieldPanel;
import gui.MethodPanel.MethodPanel;
import gui.constructorPanel.ConstructorPanel;
import gui.panels.MemberPanel;
import processing.InterpreterFacade;
import processing.interpret.InterpretException;

public class Controller {

	public static final String CONSTRUCTOR = "Constructor";
	public static final String FIELD = "Field";
	public static final String METHOD = "Method";

	private InterpreterFacade interpreter;
	private Map<String,MemberPanel> panelMap;
	private SingleInstanceFrame sif;

	public Controller(SingleInstanceFrame sif) {
		this.panelMap = new HashMap<String,MemberPanel>();
		this.sif = sif;
	}

	// create constructorPanel , panel that display constructor list , and return it.
	public MemberPanel getDisplayPanel(String command,String className) throws InterpretException {
		if(Controller.CONSTRUCTOR.equals(command)) {

			this.interpreter = new InterpreterFacade(className);
			ConstructorPanel cp = new ConstructorPanel(interpreter,this);
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

		panelMap.put(Controller.FIELD,new FieldPanel(interpreter,this));

		panelMap.put(Controller.METHOD,new MethodPanel(interpreter,this));

	}

	public Object executeMethod() throws InterpretException {
		MethodItem mi = MethodItem.getSelectedItem();
		String methodName = mi.getMethodName();
		String[] args = mi.getArgs();
		Class<?>[] argsType = mi.getMethod().getParameterTypes();

		//generics 挙動不審

		if("void".equals(mi.getReturnType())) {
			this.interpreter.consumer(methodName,argsType,args);
			return null;
		} else {
			return this.interpreter.function(methodName,argsType,args);
		}
	}

	public void setField() throws InterpretException {
		FieldItem fi = FieldItem.getSelectedItem();
		String fieldName = fi.getFieldName();
		String newValue = fi.getTextField().getText();

		interpreter.setField(fieldName, newValue);

		//panel reflesh
		panelMap.put(Controller.FIELD,new FieldPanel(interpreter,this));
	}

	public SingleInstanceFrame getManagedFrame() {
		return this.sif;
	}

}
