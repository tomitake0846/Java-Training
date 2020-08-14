package ch22.ex14;

public class FloatSumCalculator {
	public float sum (String line) {
		String[] ary = line.split(" ");
		float sum = 0.0f;

		for(String f : ary) {
			try {
				sum += Float.parseFloat(f);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				throw e;
			}
		}

		return sum;
	}
}
