package ch01.ex04;

public class Prime {

	public static final int TO = 100;

	public static void main(String[] args) {
		System.out.println("Printing Prime Numver Sequence until 100");

		int current = 2;

		while(current <= TO) {

			if(isPrimeNumber(current)) {

				System.out.println(current);
			}

			current ++;
		}
	}

	public static boolean isPrimeNumber(int n) {
		if(n==2) {
			return true;
		}
		if(n<2) {
			return false;
		}
		//return false because even number excluding 2 are not prime number.
		if((n % 2)==0) {
			return false;
		}

		//About n, there is no divisor greater than n/2.
		//For that reason , divisor searches until n/2.
		int to = (n+1) / 2;

		for(int i=3; i < to; i+=2) {

			if((n % i) == 0) {
				return false;
			}
		}

		return true;
	}

}
