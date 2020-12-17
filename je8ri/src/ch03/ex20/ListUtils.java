package ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ListUtils  {
	public static <T,U> List<U> map(List<T> list, Function<T,U> mapper) {
		if(list == null) {
			throw new NullPointerException("object 'list' is null.");
		}
		List<U> l = new ArrayList<>(list.size());
		for(T element : list) {
			l.add(mapper.apply(element));
		}
		return l;
	}
}
