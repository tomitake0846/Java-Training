package ch10.ex02;

public class Escape {
	public String escape(String target) {

		char[] chars = target.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<chars.length;i++) {
			sb.append(escape(chars[i]));
		}
		return sb.toString();
	}
	private String escape(char c) {
		switch(c) {
			case '\\': return "\\\\";
			case '"' : return "\\\"";
			case '\n': return "\\n";
			case '\t': return "\\t";
			case '\b': return "\\b";
			case '\r': return "\\r";
			case '\f': return "\\f";
			case '\'': return "\\\'";
			default : return c+"";
		}
	}
}
