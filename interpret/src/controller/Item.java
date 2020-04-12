package controller;

import java.lang.reflect.Modifier;

public class Item {
	public String trimPackageName(String type) {
		int dotIndex = type.lastIndexOf(".");
		if(dotIndex < 0) {
			return type;
		}
		return type.substring(dotIndex+1);
	}

	public String modifierString(int v) {
	    if (Modifier.isPrivate(v))  return "private";
	    if (Modifier.isPublic(v))  return "public";
	    if (Modifier.isProtected(v)) return "protected";
	    return "";
	}
}
