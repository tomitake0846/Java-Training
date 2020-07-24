package controller;

import java.lang.reflect.Modifier;

import controller.argument.ArgumentItem;
import controller.argument.ArgumentItemFactory;

public class MemberInformation {

	private ArgumentItem[] argumentItems;

	public MemberInformation(Class<?>... parameterTypes) {
		this.argumentItems = new ArgumentItem[parameterTypes.length];
		for(int i=0;i<parameterTypes.length;i++) {
			Class<?> type = parameterTypes[i];
			argumentItems[i] = ArgumentItemFactory.getInstance(type);
		}
	}

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

	public ArgumentItem[] getArgumentItems() {
		return this.argumentItems;
	}
}
