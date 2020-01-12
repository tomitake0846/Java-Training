package ch16.ex02;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeDesc {
	public static void main(String[] args) {
		TypeDesc desc = new TypeDesc();
		for(String name : args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass,0,basic);
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}

		}
	}

	// デフォルトで標準出力に表示する
	private java.io.PrintStream out = System.out;

	private static String[] basic = {"class","interface","enum","annotation"};
	private static String[] supercl = {"extends","implements"};
	private static String[] iFace = {null,"extends"};

	private void printType(Type type,int depth, String[] labels) {
		//再帰呼び出し停止。スーパークラスが存在しない
		if(type == null) {
			return;
		}

		//TypeをClassオブジェクトに変換する
		Class<?> cls = null;
		if(type instanceof Class<?>) {
			cls = (Class<?>)type;
		}
		else if(type instanceof ParameterizedType) {
			cls = (Class<?>)((ParameterizedType)type).getRawType();
		} else {
			throw new Error("unexpected non-class type");
		}

		if(Object.class.equals(cls)) {
			return;
		}

		//この型を表示
		for(int i=0;i<depth;i++) {
			out.print(" ");
		}
		//annotation ... 3
		//enum ... 2
		//interface ... 1
		//上記以外 ... 0
		int kind = cls.isAnnotation() ? 3 : cls.isEnum() ? 2: cls.isInterface() ? 1 : 0;

		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());

		//あれば、ジェネリック型パラメータを表示
		TypeVariable<?>[] params= cls.getTypeParameters();
		if(params.length > 0) {
			out.print('<');
			for(TypeVariable<?> param : params) {
				out.print(param.getName());
				out.print(",");
			}
			out.print("\b\b>");
		}

		//インナークラスだった場合の処理
		if(cls.isMemberClass()) {
			Class<?>[] outers = cls.getDeclaredClasses();
			out.print(" inner class with ");
			for(Class<?> outer : outers) {
				out.print(outer.getName()+" ");
			}
			out.println();
		} else {
			out.println(" not inner class");
		}

		//このクラスが実装しているすべてのインタフェースを表示
		Type[] interfaces = cls.getGenericInterfaces();
		for(Type iface : interfaces) {
			printType(iface,depth + 1, cls.isInterface() ? iFace : supercl);
		}
		printType(cls.getGenericSuperclass(),depth + 1,supercl);
	}
}
