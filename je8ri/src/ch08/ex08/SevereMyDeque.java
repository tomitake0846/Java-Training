package ch08.ex08;

import java.util.ArrayDeque;
import java.util.Collections;

public class SevereMyDeque extends MyDeque{
	public SevereMyDeque() {
		this.q = Collections.checkedQueue(new ArrayDeque<>(), Sub.class);
	}
}
