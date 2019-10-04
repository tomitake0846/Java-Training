package ch03.ex12;

public abstract class SortHarness {

	//
	protected abstract int compare(Object obj1, Object obj2);

	public void sort(Object[] array) {
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
