package ch03.ex05;

public class BenchmarkTest extends Benchmark{

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		BenchmarkTest test = new BenchmarkTest();
		test.start();
	}

	@Override
	public void run() {

		TestProcess tp = new TestProcess();
		tp.test(100000);

	}

}
