package ch04.ex02;

public class Main {
	public static void main(String[] args) {
		TestObj[] array = new TestObj[5];
		array[0] = new TestObj(18);
		array[1] = new TestObj(839);
		array[2] = new TestObj(99);
		array[3] = new TestObj(33);
		array[4] = new TestObj(823);
		SortTestObj sorter = new SortTestObj();
		sorter.sort(array);
		for(TestObj obj : array) {
			System.out.println(obj.getId());
		}
	}
}
