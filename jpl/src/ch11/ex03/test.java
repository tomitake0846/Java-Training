package ch11.ex03;

import java.util.Iterator;

import ch11.ex02.Attr;

public class test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		test2 t = new test2();
		Attr<Integer> a = new Attr<Integer>("hoge");
		Attr<String> s = new Attr<String>("hoge");
		t.add(a);
		t.add(s);
		System.out.println("test");
		System.out.println(s.getValue());
	}

}

class test2 implements Attributed {

	@Override
	public void add(Attr newAttr) {
		// TODO 自動生成されたメソッド・スタブ
		newAttr.setValue(100);

	}

	@Override
	public Attr find(String attrName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Attr remove(String attrName) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public Iterator<Attr> attrs() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}