package processing.interpret;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodInterpret {
	private Object instance;
	private Method[] methods;

	public MethodInterpret(Object instance) {
		this.instance = instance;
		this.methods = instance.getClass().getMethods();
	}

	public Method[] getMethods() {
		return this.methods;
	}

	public void consumer(String methodName,Object...args) throws InterpretException {
		Method method;
		Class<?> [] params = getParamsClass(args);
		try {
			method = this.instance.getClass().getMethod(methodName,params);
			method.invoke(this.instance, args);
		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal methodName ["+methodName+"] or arguments [" + Arrays.toString(args) +"]",e);
		}
	}
	public Object function(String methodName,Object...args) throws InterpretException {
		Method method;
		Class<?> [] params = getParamsClass(args);
		try {
			method = this.instance.getClass().getMethod(methodName,params);
			return method.invoke(this.instance,args);

		} catch (NoSuchMethodException | SecurityException |
				IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal methodName ["+methodName+"] or arguments [" + Arrays.toString(args) +"]",e);
		}
	}
	public Class<?>[] getParametersType(String methodName) throws InterpretException {
		Method method;
		try {
			method = this.instance.getClass().getMethod(methodName);
			return method.getParameterTypes();

		} catch (NoSuchMethodException | SecurityException |
				IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal methodName ["+methodName+"]",e);
		}
	}
	private Class<?>[] getParamsClass(Object[] args) {
		Class<?> [] params = new Class<?>[args.length];
		for(int i=0;i<params.length;i++) {
			params[i] = args[i].getClass();
		}
		return params;
	}
}
