package ch01.ex07;

public interface Runner {
	public static Runnable andThen(Runnable r1,Runnable r2) {
		return () -> {
			r1.run();
			r2.run();
		};
	}
}
