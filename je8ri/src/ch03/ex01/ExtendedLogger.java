package ch03.ex01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendedLogger {

	private Logger logger;

	public ExtendedLogger(Logger logger) {
		this.logger = logger;
	}

	public ExtendedLogger() {
		this.logger = Logger.getLogger("default");
	}

	public void logIf(Level level,Supplier<Boolean> test,Supplier<String> message) {
		if(logger.isLoggable(level)) {
			if(test.get()) {
				this.logger.log(level, message);
			}
		}
	}

}
