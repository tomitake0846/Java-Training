package gui;

import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import processing.Interpret;
import processing.InterpretException;

public class InterpretPanel extends JPanel{

	private Map<String,JTextField> fieldMap;
	private Interpret interpret;
	//only called in Frame class.
	InterpretPanel(String objectName) throws InterpretException{
		fieldMap = new HashMap<String,JTextField>();
		interpret = new Interpret(objectName);
		createFieldPanel(objectName);
	}

	private void createFieldPanel(String objectName) throws InterpretException{
		Field[] fields = interpret.getFields();
		setLayout(new GridLayout(fields.length,2));

		for(Field field : fields) {
			String fieldName = field.getName();
			JTextField textField = new JTextField(interpret.getFieldValue(fieldName).toString());
			fieldMap.put(fieldName,textField);
			add(new JLabel(fieldName));
			add(textField);
			
		}
	}
	public void update() {
		for(String fieldName : fieldMap.keySet()) {
//			Object value = interpret.getFieldValue(fieldName);
			interpret.setField(fieldName,fieldMap.get(fieldName).getText());
		}
	}
}
