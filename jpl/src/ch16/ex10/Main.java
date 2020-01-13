package ch16.ex10;

public class Main {

	public static void main(String[] args) {
		Interpret i = new Interpret();
		i.generateArray("java.lang.String", 2);
		i.setArrayElement("test0", 0);
		i.setArrayElement("test1", 1);
		System.out.println(i.getArrayElement(0));
		System.out.println(i.getArrayElement(1));
		i.prepareRunArrayElementMethod(0);
		System.out.println(i.runArrayElementFunction("toString"));

//		i=new Interpret();
		i.generateArray("java.lang.String",2,2);
		i.setArrayElement("test00", 0,0);
		i.setArrayElement("test01", 0,1);
		i.setArrayElement("test10", 1,0);
		i.setArrayElement("test11", 1,1);
		System.out.println(i.getArrayElement(0,0));
		System.out.println(i.getArrayElement(0,1));
		System.out.println(i.getArrayElement(1,0));
		System.out.println(i.getArrayElement(1,1));
		i.prepareRunArrayElementMethod(1,1);
		System.out.println(i.runArrayElementFunction("toString"));
	}

}
