package processing.interpret;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorInterpret {

	private final Object INSTENCE;
	private final Constructor<?>[] CONSTRUCTORS;

	public ConstructorInterpret(String className,Object...args) throws InterpretException {
		try {
			Class<?>[] params = new Class<?>[args.length];
			for(int i=0;i<args.length;i++) {
				params[i] = args[i].getClass();
			}
			Class<?> c = Class.forName(className);
			Constructor<?> constructor = c.getConstructor(params);
			this.INSTENCE = constructor.newInstance(args);
			this.CONSTRUCTORS = c.getConstructors();

		} catch (ClassNotFoundException | InstantiationException |
				IllegalAccessException | NoSuchMethodException | SecurityException |
				IllegalArgumentException | InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new InterpretException("No such class ["+className+"] or arguments [" + Arrays.toString(args) +"]",e);
		}
	}

	public Object getInstance() {
		return this.INSTENCE;
	}

	public Constructor<?>[] getConstructors() {
		return this.CONSTRUCTORS;
	}
}
