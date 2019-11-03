package ch10.ex01;

public class Escape {
	public String escape(String target) {

		if(target.contains("\\")) {
			target = target.replace("\\","\\\\");
		}
		if(target.contains("\"")) {
			target = target.replace("\"", "\\\"");
		}
		if(target.contains("\n")) {
			target = target.replace("\n","\\n");
		}
		if (target.contains("\t")) {
			target = target.replace("\t","\\t");
		}
		if (target.contains("\b")) {
			target = target.replace("\b", "\\b");
		}
		if (target.contains("\r")) {
			target = target.replace("\r", "\\r");
		}
		if (target.contains("\f")) {
			target = target.replace("\f","\\f");
		}
		if(target.contains("\'")) {
			target = target.replace("\'","\\\'");
		}

		return target;
	}
}
