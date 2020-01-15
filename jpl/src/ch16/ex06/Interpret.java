package ch16.ex06;

import java.lang.reflect.Field;

public class Interpret {

	private Object instance;
	private Field[] fields;

	public Interpret(String type) {
		try {
			Class<?> c = Class.forName(type);
			this.instance = c.newInstance();
			this.fields = c.getFields();

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public void setField(String fieldName,Object value) {
		Field field;
		try {
			field = this.instance.getClass().getField(fieldName);
			field.setAccessible(true);
			field.set(instance, value);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public Field[] getFields() {
		return this.fields;
	}
	public Object getFieldValue(String fieldName) {
		Field field;
		try {
			field = this.instance.getClass().getField(fieldName);
			field.setAccessible(true);
			return field.get(this.instance);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}

	public Object getInstance() {
		return this.instance;
	}
}
