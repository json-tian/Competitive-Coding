import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class DMOPC14_P6_SelectiveCutting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int trees = Integer.parseInt(input.readLine());
		int[][] treeLengths = new int[trees][2];
		String[] temp = input.readLine().split(" ");
		for (int i = 0; i < trees; i ++) {
			treeLengths[i][0] = Integer.parseInt(temp[i]);
			treeLengths[i][1] = i;
		}

		//FenwickTree Solution
		Tree1 tree = new Tree1();
		Tree1.constructBITree(trees); 

		Arrays.sort(treeLengths, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return (a[0] > b[0] ? -1 : (a[0] == b[0] ? 0 : 1));
			}
		});

		int queries = Integer.parseInt(input.readLine());
		long[][] query = new long[queries][5];

		for (int i = 0; i < queries; i ++) {
			temp = input.readLine().split(" ");
			query[i][0] = Long.parseLong(temp[2]);	//Log Length
			query[i][1] = i;	//Order to print out
			query[i][2] = Long.parseLong(temp[0]);	//a value
			query[i][3] = Long.parseLong(temp[1]);	//b value
			query[i][4] = 0;

			//			if (a != 0)
			//				System.out.println(tree.getSum(b) - tree.getSum(a-1)); 
			//			else
			//				System.out.println(tree.getSum(b)); 

		}
		Arrays.sort(query, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return (o1[0] > o2[0] ? -1 : (o1[0] == o2[0] ? 0 : 1));
			}
		});

		//		for (int i = 0; i < trees; i ++) {
		//			System.out.print(query[i][0]);
		//		}
		//
		//		System.out.println();

		//add logs one by one
		int queryCounter = 0;
		boolean done = false;
		for (int i = 0; i < trees; i ++) {
			while (query[queryCounter][0] > treeLengths[i][0]) {
				if (query[queryCounter][2] != 0)
					query[queryCounter][4] = (long)tree.getSum(query[queryCounter][3]) - (long)(tree.getSum(query[queryCounter][2]-1));
				else
					query[queryCounter][4] = (long)tree.getSum(query[queryCounter][3]);
				if (queryCounter < (queries-1))
					queryCounter++;
				else {
					done = true;
					break;
				}
			}
			tree.updateBIT(trees, treeLengths[i][1], treeLengths[i][0]);
		}
		for (int i = 0; i < queries; i ++) {
			if (query[i][0] <= treeLengths[trees-1][0]) {
				if (query[i][2] != 0)
					query[i][4] = (long)tree.getSum(query[i][3]) - (long)(tree.getSum(query[i][2]-1));
				else
					query[i][4] = (long)tree.getSum(query[i][3]);
			}
		}

		Arrays.sort(query, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return (o1[1] < o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1));
			}
		});

		for (int i = 0; i < queries; i ++) {
			System.out.println(query[i][4]);
		}

	}
}

class Tree1 {
	public static int[] bit = new int[1000000];	//Maximum based on constraints

	public static void constructBITree(int length) { 
		for (int i = 1; i <= length; i++) 
			bit[i] = 0; 

		//for (int i = 0; i < length; i++) 
		//updateBIT(length, i, array[i]); 
	}

	public long getSum(long num) { 
		long sum = 0;
		num = num + 1; 
		while(num > 0) {    
			sum += bit[(int)num]; 
			num -= num & (-num); 
		} 
		return sum; 
	} 

	public void updateBIT(int length, int num, int value) { 
		num = num + 1; 

		while (num <= length) { 
			bit[num] += value; 
			num += num & (-num); 
		} 
	} 
}