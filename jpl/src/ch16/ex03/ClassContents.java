package ch16.ex03;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public class ClassContents {

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);

			//継承したメンバーを含む、全publicメンバーを表示
			printMember(c.getFields(),false);
			//"c"クラスで宣言されたメンバーを表示
			//上記のprintMember()でpublicメンバーは表示しているため、publicメンバーは表示しない。
			//第二引数のbooleanは、「publicメンバーを表示しない」という設定を制御する
			//第二引数がtrue ... publicメンバーを表示しない
			//第二引数がfalse ... publicメンバーを表示する
			printMember(c.getDeclaredFields(),true);

			printMember(c.getConstructors(),false);
			printMember(c.getDeclaredConstructors(),true);


			printMember(c.getMethods(),false);
			printMember(c.getDeclaredMethods(),true);

		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void printMember(Member[] mems,boolean flag) {

		for(Member m : mems) {

			if(m.getDeclaringClass() == Object.class) {
				continue;
			}

			if(flag) {
				String modifier = Modifier.toString(m.getModifiers());
				if("public".equals(modifier)) {
					continue;
				}
			}

			String decl = m.toString();
			System.out.print(" ");
			System.out.println(strip(decl,"java.lang."));
		}
	}
	private static String strip(String decl , String target) {
		return decl.replace(target,"");
	}

}
