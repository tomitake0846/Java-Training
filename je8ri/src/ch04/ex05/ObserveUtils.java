package ch04.ex05;

import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;

public class ObserveUtils {
	public static <T,R> ObservableValue<R> observe(Function<T,R> f,ObservableValue<T> t) {
		ObjectProperty<R> op = new SimpleObjectProperty<>();
		op.bind(Bindings.createObjectBinding( () -> f.apply(t.getValue()) , t));
		return op;
	}

	public static <T,U,R> ObservableValue<R> observe(BiFunction<T,U,R> f, ObservableValue<T> t,ObservableValue<U> u) {
		ObjectProperty<R> op = new SimpleObjectProperty<>();
		op.bind(Bindings.createObjectBinding( () -> f.apply(t.getValue(),u.getValue()) , t));
		return op;
	}
}
