package gui.FieldPanel;

import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

import controller.Controller;
import controller.FieldItem;
import gui.panels.MemberPanel;
import processing.FieldInterface;
import processing.interpret.InterpretException;

public class FieldPanel extends MemberPanel{
	private FieldInterface interpret;

	public FieldPanel(FieldInterface interpreter,Controller controller) throws InterpretException{
		super(Controller.FIELD,controller,interpreter.getFields().length,"modifier","field name","value");
		interpret = interpreter;
		createFieldPanel();
	}

	private void createFieldPanel() throws InterpretException{
		Field[] fields = interpret.getFields();
		setLayout(new GridLayout(fields.length+1,3));

		add(getTitlePanel());

		Arrays.sort(fields,Comparator.comparing(Field::getName));

		for(Field field : fields) {
			String fieldName = field.getName();
			FieldItem fi = new FieldItem(field,interpret.getFieldValue(fieldName).toString());
			add(new FieldItemPanel(fi,getController()));
		}
	}
}
