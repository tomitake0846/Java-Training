package ch04.ex02;

public class SortTestObj implements SortHarness{
	public int compare(Object obj1,Object obj2) {
		TestObj instance1 = (TestObj)obj1;
		TestObj instance2 = (TestObj)obj2;
		if(instance1.getId() >= instance2.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

	public void sort(Object[] array)  {
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(compare(array[j-1],array[j]) >= 0) {
					Object dummy = array[j-1];
					array[j-1]=array[j];
					array[j] = dummy;
				}
			}
		}
	}

}
