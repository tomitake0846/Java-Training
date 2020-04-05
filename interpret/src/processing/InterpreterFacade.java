package processing;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import processing.interpret.ConstructorInterpret;
import processing.interpret.FieldInterpret;
import processing.interpret.InterpretException;
import processing.interpret.MethodInterpret;

public class InterpreterFacade implements FieldInterface,MethodInterface,ConstructorInterface{
	private FieldInterpret fi;
	private MethodInterpret mi;
	private ConstructorInterpret ci;
	public static final InterpreterFacade INTERPRETER = new InterpreterFacade();

	//singleton
	private InterpreterFacade() {};

	public void Construct(String className,Object...args) throws InterpretException {
		try {
			//how implements?
			this.ci = new ConstructorInterpret(className,args);

			// create instance with ConstructorInterpret
			Object instance = ci.getInstance();

			// create Field Interpret
			this.fi = new FieldInterpret(instance);

			// create Method Interpret
			this.mi = new MethodInterpret(instance);

		} catch (SecurityException | IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("No such class ["+className+"] or arguments [" + Arrays.toString(args) +"]",e);
		}
	}

	//FieldInterpret Facade
	@Override
	public void setField(String fieldName,Object value) throws InterpretException {
		Class<?> type = fi.getFieldType(fieldName);
		Object v = convert(type,(String) value);
		this.fi.setField(fieldName, v);
	}
	@Override
	public Field[] getFields() {
		return this.fi.getFields();
	}
	@Override
	public Object getFieldValue(String fieldName) throws InterpretException {
		return this.fi.getFieldValue(fieldName);
	}

	//MethodInterpret Facade
	@Override
	public Method[] getMethods() {
		return this.mi.getMethods();
	}
	@Override
	public void consumer(String methodName,Object...args) throws InterpretException {
		Class<?>[] types = mi.getParametersType(methodName);
		Object[] v = convert(types,(String[])args);
		this.mi.consumer(methodName,v);
	}
	@Override
	public Object function(String methodName,Object...args) throws InterpretException {
		return this.mi.function(methodName, args);
	}

	//ConstructorInterpret Facade
	@Override
	public Constructor<?>[] getConstructors() {
		return this.ci.getConstructors();
	}

	private Object convert(Class<?> type,String value) {
		String typeName = type.getName();
		switch(typeName) {
		case "char" : return value.charAt(0);
		case "short": return Short.parseShort(value);
		case "int" : return Integer.parseInt(value);
		case "long" : return Long.parseLong(value);
		case "byte" : return Byte.parseByte(value);
		case "float" : return Float.parseFloat(value);
		case "double" : return Double.parseDouble(value);
		case "boolean" : return Boolean.parseBoolean(value);
		default : return null;
		}
	}
	private Object[] convert(Class<?>[] types,String[] args) {
		Object[] result = new Object[types.length];
		for(int i=0;i<result.length;i++) {
			result[i] = convert(types[i],args[i]);
		}
		return result;
	}
}
