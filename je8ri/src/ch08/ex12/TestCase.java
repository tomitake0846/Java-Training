package ch08.ex12;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Target;
@Target(METHOD)
public @interface TestCase {
	int params();
	int exprcted();
}
