package processing;

import java.lang.reflect.Method;

import processing.interpret.InterpretException;

public interface MethodInterface {
	Method[] getMethods();
	void consumer(String methodName,Class<?>[] argsType ,String[] args) throws InterpretException;
	Object function(String methodName,Class<?>[] argsType ,String[] args) throws InterpretException;
}
