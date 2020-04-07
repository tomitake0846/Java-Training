package gui.panels;

import java.awt.GridLayout;
import java.lang.reflect.Field;

import processing.FieldInterface;
import processing.interpret.InterpretException;

public class FieldPanel extends MemberPanel{
	private FieldInterface interpret;

	public FieldPanel(FieldInterface interpreter) throws InterpretException{
		super("modifier","field name","value");
		interpret = interpreter;
		createFieldPanel();
	}

	private void createFieldPanel() throws InterpretException{
		Field[] fields = interpret.getFields();
		setLayout(new GridLayout(fields.length+1,3));

		add(getTitlePanel());
		for(Field field : fields) {
			String fieldName = field.getName();
			String modifier = modifierString(field.getModifiers());
			String fieldValue = interpret.getFieldValue(fieldName).toString();
			add(new ItemPanel(this,modifier,fieldName,fieldValue));
		}
	}

	@Override
	public void update(ItemPanel itemPanel) throws InterpretException {
		System.out.println("Clicked!");
		String fieldName = itemPanel.getItemName();
		String value = itemPanel.getParams()[0];
		this.interpret.setField(fieldName, value);
	}
}
