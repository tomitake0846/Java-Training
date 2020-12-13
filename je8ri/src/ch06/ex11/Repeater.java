package ch06.ex11;

import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Repeater <T> {
	public static <T> CompletableFuture<T> repeat(Supplier<T> action,Predicate<T> until) {
		return CompletableFuture.supplyAsync(action)
				.thenComposeAsync(input-> {
					if(until.test(input)) {
						return CompletableFuture.completedFuture(input);
					} else {
						return repeat(action,until);
					}
				});
	}
}
