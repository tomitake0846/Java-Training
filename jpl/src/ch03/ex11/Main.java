package ch03.ex11;

public class Main {

	public static void main(String[] args) {
		SimpleSortDouble instance = new SimpleSortDouble();
//		vulnerability_1(instance);
		double[] array = {1,2,5,4,2};
		SortMetrics sm1 = instance.sort(array);
		System.out.println(sm1);
		instance.probe(2);
		instance.probe(2);
		instance.probe(2);
		instance.probe(2);

		SortMetrics sm2 = instance.getMetrics();
		System.out.println(sm1);
		System.out.println(sm2);
//		sm.init();
//		System.out.println(sm);

	}
	public static void vulnerability_1(SortDouble instance) {
		//If it has called "compare","probe", "swap" or "doSort" method before call "sort(double[]) ,
		//it will occurs NullPointerException.
		instance.compare(0, 0);//NullPointerException
		instance.probe(0);//NullPonterException
		instance.swap(0, 1);//NullPouterException
		instance.doSort();//NullPointerException
	}

	public static void vulnerability_2(SortDouble instance) {
		double[] array = {1,2,5,4,2};
		instance.sort(array);

		//if it has been inputed negative number or grater than array.length ,
		//it will occurs ArrayOutObBoundsException.
		instance.compare(-1, 100);
	}
}
