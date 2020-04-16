package ch22.ex02;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class WhichChars {
	private BitSet used = new BitSet();
	private Set<Character> set;

	public WhichChars(String str) {
		set = new HashSet<Character>();

		for(int i=0;i<str.length();i++) {
			set.add(str.charAt(i));
			used.set(str.charAt(i));
		}
	}

	public String toString() {
		String desc = "[";
		for(int i=used.nextSetBit(0);i>=0;i=used.nextSetBit(i+1)) {
			desc += (char)i;
		}
		return desc+"]";
	}
}
