package processing.interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorInterpret {

	private Class<?> c;
	private Constructor<?>[] CONSTRUCTORS;

	public ConstructorInterpret(String className) throws InterpretException{
		try {
			this.c = Class.forName(className);
			this.CONSTRUCTORS = c.getConstructors();
		} catch (ClassNotFoundException | SecurityException |
				IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("No such class ["+className+"]",e);
		}
	}

	public Object createInstance(Class<?>[] argumentTypes,Object...args) throws InterpretException {
		try {
			Constructor<?> constructor = c.getConstructor(argumentTypes);
			return constructor.newInstance(args);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("Illegal arguments [" + Arrays.toString(args) +"]",e);
		}
	}

	public Constructor<?>[] getConstructors() {
		return this.CONSTRUCTORS;
	}
}
