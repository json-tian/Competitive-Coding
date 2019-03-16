import java.util.Arrays;
import java.util.Comparator;

public class SortingMatrix {

	public static void main(String[] args) {
		int[][] array = {
				{1, 1, 1},
				{3, 4, 4},
				{2, 2, 2}
		};

		Arrays.sort(array, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[0] < b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
			}
		});
		
		Arrays.sort(array, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[0] > b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
			}
		});
		
		for (int i = 0; i < array.length; i ++) {
			for (int j = 0; j < array[0].length; j ++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

}
