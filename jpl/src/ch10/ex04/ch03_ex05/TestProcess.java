package ch10.ex04.ch03_ex05;

public class TestProcess {
	public void test(int index) {
//		for(int i=0;i<index;i++) {
//
//		}
		int i = 0;
		//while
		while(i < index) {
			i++;
		}

		//do-while
//		do {
//			i++;
//		}while(i <= index);

		/*
		 * while , do-whileのどちらでも書き直せるが、どちらも不適切。
		 * ループ回数がindex回と決まっているため、for文が適切。
		 * */
	}
}
