package ch07.ex03;

public class TriangleOfPascal {

	private final int HEIGHT;
	private int triangleOfPascal[][];

	public TriangleOfPascal(int height) {
		this.HEIGHT = height;
		init();
	}

	public void paint() {
		for(int i=0;i<triangleOfPascal.length;i++) {
			for(int j=0;j<triangleOfPascal[i].length;j++) {
				System.out.print(triangleOfPascal[i][j]+" ");
			}
			System.out.println();
		}
	}

	private void init() {
		triangleOfPascal = new int[HEIGHT][];
		triangleOfPascal[0] = new int[]{1};

		for(int i=1;i<HEIGHT;i++) {
			triangleOfPascal[i] = getRows(i);
		}

	}

	private int[] getRows(int row) {
		int[] dummy = new int[row+1];
		int[] prevArray = triangleOfPascal[row-1];

		for(int i=0;i<dummy.length;i++) {
			dummy[i] = getValue(i-1,i,prevArray);
		}
		return dummy;
	}

	private int getValue(int leftIndex,int rightIndex,int[] prevArray) {
		if(leftIndex < 0) {
			return prevArray[rightIndex];

		} else if (rightIndex >= prevArray.length) {
			return prevArray[leftIndex];

		} else {
			return prevArray[leftIndex] + prevArray[rightIndex];
		}
	}
}
