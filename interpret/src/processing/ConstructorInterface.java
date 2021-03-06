package processing;

import java.lang.reflect.Constructor;

import processing.interpret.InterpretException;

public interface ConstructorInterface {
	Constructor<?>[] getConstructors();
	void Construct(Constructor<?> target,Object...args) throws InterpretException;
}
