package ch03.ex09;

import java.lang.reflect.Field;

public class FieldReflector {
	public static Object getFieldValue(Object instance,String fieldName) {
		try {
			Field field = instance.getClass().getField(fieldName);
			return field.get(instance);
		} catch (NoSuchFieldException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return null;

	}
}
