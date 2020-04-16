package processing.interpret;

import java.lang.reflect.Field;

public class FieldInterpret {
	private Object instance;
	private Field[] fields;

	public FieldInterpret(Object instance) {
		this.instance = instance;
		this.fields = instance.getClass().getFields();
//		this.fields = instance.getClass().getDeclaredFields();
	}

	public void setField(String fieldName,Object value) throws InterpretException {
		try {
			Field field = getField(fieldName);
			field.setAccessible(true);
//			setPrimitiveField(field,value);

//			System.out.println("field name:"+fieldName);
//
//			Field modifier = Field.class.getDeclaredField("modifiers");
//			modifier.setAccessible(true);
//			modifier.setInt(field, field.getModifiers() & ~Modifier.PRIVATE & ~Modifier.FINAL);

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
//			field = this.instance.getClass().getDeclaredField(fieldName);
			field = this.instance.getClass().getField(fieldName);
//			field.setAccessible(true);
			return field;
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal fieldName ["+fieldName+"]",e);
		}
	}

	private void setPrimitiveField(Field field,Object value) throws InterpretException {

		try {
		switch(field.getType().getName()) {
		case "char" : field.setChar(this.instance,(char) value); break;
		case "short": field.setShort(this.instance,(short) value); break;
		case "int" : field.setInt(this.instance,(int) value);break;
		case "long" : field.setLong(this.instance,(long) value);break;
		case "byte" : field.setByte(this.instance,(byte) value);break;
		case "float" : field.setFloat(this.instance,(float) value);break;
		case "double" : field.setDouble(this.instance,(double) value);break;
		case "boolean" : field.setBoolean(this.instance,(boolean) value);break;
		}
		} catch (Exception e) {
			throw new InterpretException("fatal Error",e);
		}

	}
}
