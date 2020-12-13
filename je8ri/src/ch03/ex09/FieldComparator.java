package ch03.ex09;

public class FieldComparator {
	private Object instanceA;
	private Object instanceB;
	public FieldComparator(Object instanceA,Object instanceB) {
		this.instanceA = instanceA;
		this.instanceB = instanceB;
	}

	public int lexicographicComparator(String... fieldNames) {
		for(String fieldName : fieldNames) {
			Object va = FieldReflector.getFieldValue(instanceA, fieldName);
			Object vb = FieldReflector.getFieldValue(instanceB, fieldName);
			int diff = va.toString().compareTo(vb.toString());
			if(diff != 0) {
				return diff;
			}
		}

		return 0;
	}
}
