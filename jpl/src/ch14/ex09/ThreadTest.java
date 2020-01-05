package ch14.ex09;

public class ThreadTest {

	int count;

	public void run() {
		ThreadGroup tg = new ThreadGroup("tg");

		getThread(tg).start();
		getThread(tg).start();
		getThread(tg).start();

		test(tg);
	}

	private void test(ThreadGroup tg) {
		while(true) {

//			tg.

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	private Thread getThread(ThreadGroup tg) {
		Thread t = new Thread(tg,new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep((int)(Math.random() * 1000 * 30));
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		},"Thread"+count);
		count++;
		return t;
	}

}
