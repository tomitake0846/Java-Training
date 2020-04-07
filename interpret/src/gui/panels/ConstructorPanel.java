package gui.panels;

import java.awt.GridLayout;
import java.lang.reflect.Constructor;

import processing.ConstructorInterface;
import processing.interpret.InterpretException;

public class ConstructorPanel extends MemberPanel{
	private Constructor<?>[] constructors;
	public ConstructorPanel(ConstructorInterface interpreter) throws InterpretException {
		super("modifier","field name","args");
		constructors = interpreter.getConstructors();
		createConstructorPanel();
	}

	private void createConstructorPanel() {
		setLayout(new GridLayout(this.constructors.length+1,3));

		add(getTitlePanel());
		for(Constructor<?> constructor : this.constructors) {
			String cName = constructor.getName();
			String modifier = modifierString(constructor.getModifiers());
			add(new ItemPanel(this,modifier,cName,args(constructor)));
		}
	}

	private String args(Constructor<?> constructor) {
		StringBuilder sb = new StringBuilder("(");
		for(Class<?> param : constructor.getParameterTypes()) {
			sb.append(param.getName()+",");
		}
		return sb.toString().replaceAll(",$","") + ")";
	}

	@Override
	public void update(ItemPanel itemPanel) {
		System.out.println("clicked!");
	}
}
