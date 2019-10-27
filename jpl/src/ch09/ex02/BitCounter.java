package ch09.ex02;

public class BitCounter {
	public int BitCount(int target) {

		if(target < 0) {
			target = target + Integer.MAX_VALUE + 1;
		}

		int count = 0;
		int mask = 1;
		while(target != 0) {

			if((target & mask) == 1) {
				count++;
			}

			target = target >> 1;
		}

		return count;
	}
}
