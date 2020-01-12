package ch16.ex08;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

	public void consumer(String methodName,Object...args) {
		Method method;
		Class<?> [] params = new Class<?>[args.length];
		for(int i=0;i<params.length;i++) {
			params[i] = args[i].getClass();
		}
		try {
			method = this.instance.getClass().getMethod(methodName,params);
			method.invoke(this.instance, args);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public Object function(String methodName,Object...args) {
		Method method;
		Class<?> [] params = new Class<?>[args.length];
		for(int i=0;i<params.length;i++) {
			params[i] = args[i].getClass();
		}
		try {
			method = this.instance.getClass().getMethod(methodName,params);
			return method.invoke(this.instance,args);

		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
	}
}
