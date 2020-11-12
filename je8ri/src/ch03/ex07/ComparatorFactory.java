package ch03.ex07;

import java.util.Comparator;
import java.util.function.UnaryOperator;

public class ComparatorFactory {

	private UnaryOperator<String> blank = (s) -> s;
	private Comparator<String> upperLowerCase = (s1,s2) -> s1.compareTo(s2);
	private int ascOrDesc = 1;

	public Comparator<String> sort() {
		return (s1,s2) -> ascOrDesc * upperLowerCase.compare(blank.apply(s1),blank.apply(s2));
	}

	public ComparatorFactory asc() {
		this.ascOrDesc = 1;
		return this;
	}

	public ComparatorFactory desc() {
		this.ascOrDesc = -1;
		return this;
	}

	public ComparatorFactory strictUpperLowerCase() {
		this.upperLowerCase = (s1,s2) -> s1.compareToIgnoreCase(s2);
		return this;
	}

	public ComparatorFactory removeBlank() {
		this.blank = (s) -> s.replaceAll(" ","");
		return this;
	}

}
