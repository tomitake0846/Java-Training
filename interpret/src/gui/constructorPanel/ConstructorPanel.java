package gui.constructorPanel;

import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import controller.ConstructorItem;
import controller.Controller;
import gui.panels.MemberPanel;
import processing.ConstructorInterface;
import processing.interpret.InterpretException;

public class ConstructorPanel extends MemberPanel{
	private Constructor<?>[] constructors;
	public ConstructorPanel(ConstructorInterface interpreter,Controller controller) throws InterpretException {
		super(Controller.CONSTRUCTOR,controller,interpreter.getConstructors().length,"modifier","Constructor name","args");
		constructors = interpreter.getConstructors();
		createConstructorPanel();
	}

	private void createConstructorPanel() {
		setLayout(new GridLayout(this.constructors.length+1,3));

		add(getTitlePanel());

		for(Constructor<?> constructor : this.constructors) {
			ConstructorItem ci = new ConstructorItem(constructor);
			add(new ConstructorItemPanel(ci,getController()));
		}
	}

}
