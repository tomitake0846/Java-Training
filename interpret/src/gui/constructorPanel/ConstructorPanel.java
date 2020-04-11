package gui.constructorPanel;

import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import controller.ConstructorItem;
import gui.panels.ItemPanel;
import gui.panels.MemberPanel;
import processing.ConstructorInterface;
import processing.interpret.InterpretException;

public class ConstructorPanel extends MemberPanel{
	private Constructor<?>[] constructors;
	private ConstructorInterface interpreteter;
	public ConstructorPanel(ConstructorInterface interpreter) throws InterpretException {
		super("modifier","field name","args");
		this.interpreteter = interpreter;
		constructors = interpreter.getConstructors();
		createConstructorPanel();
	}

	private void createConstructorPanel() {
		setLayout(new GridLayout(this.constructors.length+1,3));

		add(getTitlePanel());
		for(Constructor<?> constructor : this.constructors) {
			ConstructorItem ci = new ConstructorItem(constructor);
			add(new ConstructorItemPanel(ci));
		}
	}

	//"bug"
	private String args(Constructor<?> constructor) {
		StringBuilder sb = new StringBuilder("(");
		for(Class<?> param : constructor.getParameterTypes()) {
			sb.append(param.getName()+",");
		}
		return sb.toString().replaceAll(",$","") + ")";
	}

	@Override
	public void update(ItemPanel itemPanel) throws InterpretException {
		System.out.println("clicked!");
	}
}
