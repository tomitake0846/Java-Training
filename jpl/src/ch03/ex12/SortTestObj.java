package ch03.ex12;

public class SortTestObj extends SortHarness{
	@Override
	protected int compare(Object obj1,Object obj2) {
		TestObj instance1 = (TestObj)obj1;
		TestObj instance2 = (TestObj)obj2;
		if(instance1.getId() >= instance2.getId()) {
			return 1;
		} else {
			return -1;
		}
	}

}