package ch16.ex07;

public class Main {

	public static void main(String[] args) {
		Interpret i = new Interpret("ch16.ex07.test");
		i.consumer("printX",10);//x :10
		i.consumer("print");//test
		System.out.println(i.function("x"));//1
		System.out.println(i.function("add",10,15));//25
	}

}
//testクラスは、jpl/test/ch16/ex07で定義
//class test {
//	public int x() {
//		return 1;
//	}
//	public int add(Integer x,Integer y) {
//		return x+y;
//	}
//	public void printX(Integer x) {
//		System.out.println("x :"+x);
//	}
//	public void print() {
//		System.out.println("test");
//	}
//}
