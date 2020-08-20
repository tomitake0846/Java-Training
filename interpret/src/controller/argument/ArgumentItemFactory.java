package controller.argument;

public class ArgumentItemFactory {
	public static ArgumentItem getInstance(Class<?> type) {
		ArgumentItem item;
		if(type.isPrimitive()) {
			item = new PrimitiveArgumentItem(type.getName());
		} else if (type.getName().equals("java.lang.String")) {
			item = new PrimitiveArgumentItem(type.getName());
		}
		else {
			item = new ReferenceArgumentItem(type.getName());
		}
		return item;
	}
}
