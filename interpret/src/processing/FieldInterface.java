package processing;

import java.lang.reflect.Field;

import processing.interpret.InterpretException;

public interface FieldInterface {
	void setField(String fieldName,Object value) throws InterpretException;
	Field[] getFields();
	Object getFieldValue(String fieldName) throws InterpretException;
}
