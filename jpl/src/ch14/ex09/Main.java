package ch14.ex09;

public class Main {

	public static void main(String[] args) {
		ThreadTest tt = new ThreadTest();
		ThreadGroup parent = tt.createTestTG("foo",4);
		ThreadGroup child = tt.createTestTg("bar", 3, parent);
		tt.run(child);
	}

}
