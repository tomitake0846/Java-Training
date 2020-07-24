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
	private Object instance;

	public InterpreterFacade(String className) throws InterpretException {
		this.ci = new ConstructorInterpret(className);
	}

	public boolean hasInstance() {
		return this.instance != null;
	}
	public Object getInstance() {
		return this.instance;
	}

	@Override
	public void Construct(Constructor<?> target,Object...args) throws InterpretException {
		try {

			Object[] objects = convert(target.getParameterTypes(),args);

			// create instance with ConstructorInterpret
			this.instance = ci.createInstance(getArgumentsType(objects),objects);

			// create Field Interpret
			this.fi = new FieldInterpret(this.instance);

			// create Method Interpret
			this.mi = new MethodInterpret(this.instance);

		} catch (SecurityException | IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal arguments [" + Arrays.toString(args) +"]",e);
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
	public void consumer(String methodName,Class<?>[] argsType,Object[] args) throws InterpretException {
		Object[] v = convert(argsType,args);
		this.mi.consumer(methodName,argsType,v);
	}
	@Override
	public Object function(String methodName,Class<?>[] argsType,Object[] args) throws InterpretException {
		Object[] v = convert(argsType,args);
		return this.mi.function(methodName,argsType, v);
	}

	//ConstructorInterpret Facade
	@Override
	public Constructor<?>[] getConstructors() {
		return this.ci.getConstructors();
	}

	private Object convert(Class<?> type,String value) throws InterpretException {
		String typeName = type.getName();
		try {
			switch(typeName) {
			case "char" : return value.charAt(0);
			case "short": return Short.parseShort(value);
			case "int" : return Integer.parseInt(value);
			case "long" : return Long.parseLong(value);
			case "byte" : return Byte.parseByte(value);
			case "float" : return Float.parseFloat(value);
			case "double" : return Double.parseDouble(value);
			case "boolean" : return Boolean.parseBoolean(value);
			case "java.lang.String" : return value;
			default : {
					return null;
				}
			}
		} catch (RuntimeException e ) {
			throw new InterpretException ("Type Convertion Error",e);
		}
	}
	private Object[] convert(Class<?>[] types,Object[] args) throws InterpretException{
		Object[] result = new Object[types.length];
		for(int i=0;i<result.length;i++) {
			if(types[i].isPrimitive()) {
				result[i] = convert(types[i],(String)args[i]);
			} else if (types[i].getName().equals("java.lang.String")) {
				result[i] = convert(types[i],(String)args[i]);
			} else {
				result[i] = args[i];
			}
		}
		return result;
	}
	private Class<?>[] getArgumentsType(Object[] args) {

		Class<?>[] params = new Class<?>[args.length];
		for(int i=0;i<args.length;i++) {
			switch(args[i].getClass().getName()) {
			case "java.lang.Character" : params[i] = char.class; break;
			case "java.lang.Short": params[i] = short.class; break;
			case "java.lang.Integer" : params[i] = int.class; break;
			case "java.lang.Long" : params[i] = long.class; break;
			case "java.lang.Byte" : params[i] = byte.class; break;
			case "java.lang.Float" : params[i] = float.class; break;
			case "java.lang.Double" : params[i] = double.class; break;
			case "java.lang.Boolean" : params[i] = boolean.class; break;
			default : params[i] = args[i].getClass();
			}
		}
		return params;
	}

}
