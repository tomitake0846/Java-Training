package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

public interface ExtendedReentrantLock {
	static void withLock(ReentrantLock myLock, Supplier<Object> process) {
		myLock.lock();
		try {
			process.get();
		} finally {
			myLock.unlock();
		}
	}
}
