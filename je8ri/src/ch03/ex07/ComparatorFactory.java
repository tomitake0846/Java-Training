package ch03.ex07;

import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

public class ComparatorFactory {

	private List<UnaryOperator<String>> pendingOperations;

	//terminate
	public Comparator<String> asc() {
		return (s1,s2) -> s1.compareTo(s2);
	}

	//terminate
	public Comparator<String> desc() {
		return (s1,s2) -> s2.compareTo(s1);
	}


	public Comparator<String> strictUpperLowerCase() {
		return (s1,s2) -> s2.compareToIgnoreCase(s1);
	}

	public Comparator<String> ignoreUpperLowerCase() {
		return (s1,s2) -> s2.compareTo(s1);
	}

	public ComparatorFactory strictBlank() {

	}
	public ComparatorFactory ignoreBlank() {

	}
}
