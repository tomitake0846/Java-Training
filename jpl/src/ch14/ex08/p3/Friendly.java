package ch14.ex08.p3;

public class Friendly {
	private Friendly partner;
	private String name;
	private static boolean locked = false;

	public Friendly(String name) {
		this.name = name;
	}

	public synchronized void hug(){

		if(!locked) {
			locked = true;
		} else {
			while(locked) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println(Thread.currentThread().getName() + " in " + name + ".hug() trying to invoke " + partner.name + ".hugBack()");

		partner.hugBack();
	}

	private synchronized void hugBack() {
		System.out.println(Thread.currentThread().getName() + " in " + name + ".hugBack()");
		locked = false;
		notifyAll();
	}

	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}

	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		int count = 0;

		while(true) {

			new Thread(new Runnable() {
				public void run() {jareth.hug();}
			},"Thread1").start();

			new Thread(new Runnable() {

				public void run() {
					cory.hug();
				}
			},"Thread2").start();

			count++;
			System.out.println(count);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
}
