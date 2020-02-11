package gui;

import java.awt.GridLayout;
import java.lang.reflect.Field;

import javax.swing.JLabel;
import javax.swing.JPanel;

import processing.Interpret;
import processing.InterpretException;

public class InterpretPanel extends JPanel{

	//only called in Frame class.
	InterpretPanel(String objectName) throws InterpretException{
		FieldPanel(objectName);
	}

	private void FieldPanel(String objectName) throws InterpretException{

		Interpret i = new Interpret(objectName);
		Field[] fields = i.getFields();

		setLayout(new GridLayout(fields.length,2));

		for(Field field : fields) {
			String fieldName = field.getName();
			add(new JLabel(fieldName));
			add(new JLabel(i.getFieldValue(fieldName).toString()));
		}
	}
}
