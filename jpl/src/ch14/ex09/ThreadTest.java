package ch14.ex09;

public class ThreadTest {

	public void run(ThreadGroup tg) {
		while(tg.activeCount() >= 1) {
			System.out.println("active thread :"+tg.activeCount());
			printThread(tg);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		System.out.println("finished");
	}

	public ThreadGroup createTestTG(String name,int count) {
		ThreadGroup tg = new ThreadGroup("tg");

		for(int i=0;i<count;i++) {
			new Thread(tg,new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep((int)(Math.random() * 1000 * 30));
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			},name+i).start();
		}
		return tg;
	}
	public ThreadGroup createTestTg(String name,int count,ThreadGroup parentTG) {
		ThreadGroup tg = new ThreadGroup(parentTG,"tg");

		for(int i=0;i<count;i++) {
			new Thread(tg,new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep((int)(Math.random() * 1000 * 30));
					} catch (InterruptedException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
				}
			},name+i).start();
		}
		return tg;
	}

	public int printThread(ThreadGroup tg) {
		ThreadGroup parent = tg.getParent();
		String threadName = tg.getName();
		if("main".equals(threadName)) {
			return 0;
		}
		int depth=0;
		if(parent != null) {
			depth = printThread(parent);
			depth++;
		}

		Thread[] threads = new Thread[tg.activeCount()];
		tg.enumerate(threads);
		String ws = getWhiteSpace(depth);
		System.out.println(ws+tg.getName());
		for(Thread t : threads) {
			System.out.println(ws+" "+t.getName());
		}
		return depth;
	}

	private String getWhiteSpace(int depth) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<depth;i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
