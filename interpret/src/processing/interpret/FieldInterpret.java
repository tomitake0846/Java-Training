package processing.interpret;

import java.lang.reflect.Field;

public class FieldInterpret {
	private Object instance;
	private Field[] fields;

	public FieldInterpret(Object instance) {
		this.instance = instance;
		this.fields = instance.getClass().getFields();
	}

	public void setField(String fieldName,Object value) throws InterpretException {
		try {
			Field field = getField(fieldName);
			field.set(instance, value);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal fieldName ["+fieldName+"] or value [" + value.toString() +"]",e);
		}
	}

	public Field[] getFields() {
		return this.fields;
	}
	public Object getFieldValue(String fieldName) throws InterpretException {
		try {
			Field field = getField(fieldName);
			return field.get(this.instance);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal fieldName ["+fieldName+"]",e);
		}
	}

	public Class<?> getFieldType(String fieldName) throws InterpretException {
		try {
			Field field = getField(fieldName);
			return field.getType();
		} catch (SecurityException | IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal fieldName ["+fieldName+"]",e);
		}
	}

	private Field getField(String fieldName)  throws InterpretException {
		try {
			Field field;
			field = this.instance.getClass().getField(fieldName);
			field.setAccessible(true);
			return field;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal fieldName ["+fieldName+"]",e);
		}
	}
}
