package ch01.ex06;

public class Main {

	public static void main(String[] args) {
		new Thread(RunnableEx.uncheck( () -> {
			System.out.println("zzz");
			Thread.sleep(1000);
			System.out.println("hello!");
		})).start();

		// Threadクラスのコンストラクタには、Callable型を代入できない。
//		new Thread(RunnableEx.uncheck(new Callable<Void>() {
//			@Override
//			public Void call() throws Exception {
//				// TODO 自動生成されたメソッド・スタブ
//				return null;
//			}
//
//		})).start();
	}

}
