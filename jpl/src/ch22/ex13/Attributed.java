package ch22.ex13;

public interface Attributed {
	void add(Attr newAttr);
	Attr find(String attrName);
	Attr remove(String attrName);
	java.util.Iterator<Attr> attrs();
}

/*問1 Attr型をジェネリックで書き直すことは、よいことですか?
 * 状況による
 * Attributedインタフェースを実装したオブジェクトが、型パラメータを使用するメソッドを使用する場合(Attrに操作を加え、Attrの型が保障されなくなる場合)、
 * Attr型をジェネリックで書き直してもよいことはない気がする。
 *
 *問2 Attr型がジェネリクスだと、Attributedインタフェースにどのような影響を与えますか?
 * Attibutedインタフェースを実装したオブジェクトが1つでも稼働していると、Attibutedインタフェースで使用するAttrをジェネリックで書き直すことができない。
 * つまり、上記の条件の場合、今後記述するAttibutedインタフェースを実装したオブジェクトでは、ジェネリクスを用いたAttrは一切使用できない。
 *
 *問3 Attributedオブジェクトに対しては、どのような意味を持ちますか?
 * Attributedを実装したオブジェクト(以下Attributedオブジェクト)では、ジェネリクスなしのAttrのままである。
 * Attrクラスをジェネリクスで書き直しても、Attibutedオブジェクト内で使うのはジェネリクスなしのAttrのため、
 * Attributedオブジェクト内のAttrでは、一切型安全性は保障されない。
 *   ```
 *   class foo implements Attributed {
		public void (Attr newAttr) {
			//fooクラスで扱うAttrはジェネリクスなしなので、何でも扱える。
			//ジェネリクスで保証された型安全も、Attributedオブジェクトを使用すると、
			//一切保証されなくなる。
			Attr.add(100);
			Attr.add("hoge");
		}
		~
	}
	~
 *      foo hoge = new foo();
		Attr<String> s = new Attr<String>("hoge");
		hoge.add(s);
		System.out.println(s.getValue());/ClassCastException
		~
 *   ```
 * つまり、せっかくAttrをジェネリクスで書き直しても、Attributedオブジェクトを使用すると、Attrの型安全性は保障されなくなり、
 * ジェネリクスで書き直した意味がなくなる。
 * */
