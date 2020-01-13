package ch16.ex10;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Interpret {

	private Object instance;
	private Object array;
	private Interpret targetObject;
	public Interpret() {};
	public Interpret(String type,Object...args) {
		try {

			Class<?>[] params = new Class<?>[args.length];
			for(int i=0;i<args.length;i++) {
				params[i] = args[i].getClass();
			}

			Constructor<?> c = Class.forName(type).getConstructor(params);
			this.instance = c.newInstance(args);

		} catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | NoSuchMethodException | SecurityException |
				IllegalArgumentException | InvocationTargetException e) {
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
	public void generateArray(String arrayType,int...size) {
		try {
			Class<?> clazz = Class.forName(arrayType);
			this.array = Array.newInstance(clazz, size);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	public void setArrayElement(Object value,int...indexes) {
		Object dummy = array;
		for(int i=0;i<indexes.length-1;i++) {
			dummy = Array.get(dummy, indexes[i]);
		}
		Array.set(dummy,indexes[indexes.length-1],value);
	}

	public Object getArrayElement(int...indexes) {
		Object dummy = array;
		for(int i=0;i<indexes.length-1;i++) {
			dummy = Array.get(dummy, indexes[i]);
		}

		return Array.get(dummy,indexes[indexes.length-1]);
	}

	public void prepareRunArrayElementMethod(int...indexes) {
		Class<?> clazz = this.array.getClass().getComponentType();
		while(clazz.getComponentType() != null) {
			clazz = clazz.getComponentType();
		}
		this.targetObject = new Interpret(clazz.getName());

		this.targetObject.instance = getArrayElement(indexes);

	}
	public void runArrayElementConsumer(String methodName,Object...args) {
		this.targetObject.consumer(methodName, args);
	}
	public Object runArrayElementFunction(String methodName,Object...args) {
		return this.targetObject.function(methodName, args);
	}
}
