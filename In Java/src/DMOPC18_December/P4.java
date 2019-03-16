import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class P4 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = input.readLine().split(" ");

		int trees = Integer.parseInt(temp[0]);
		int operations = Integer.parseInt(temp[1]);

		temp = input.readLine().split(" ");
		int[] treeLengths = new int[trees];
		for (int i = 0; i < trees; i ++) {
			treeLengths[i] = Integer.parseInt(temp[i]);
		}

		Tree2 tree = new Tree2();
		tree.constructBITree(treeLengths, trees); 

		for (int i = 0; i < operations; i ++) {
			temp = input.readLine().split(" ");
			int l = Integer.parseInt(temp[0]) - 2;
			int r = Integer.parseInt(temp[1]) - 1;
			int max = Integer.parseInt(temp[2]);
			long left;
			if (l >= 0)
				left = tree.getSum(l);
			else
				left = 0;
			long right = tree.getSum(r);
			for (int k = l + 1; k < r + 1; k ++) {
				if (treeLengths[k] < max) {
					left += treeLengths[k] * 2;
				}
			}
			System.out.println(right - left);
		}
	}
}

class Tree2 {
	public long[] bit = new long[1000000];	//Maximum based on constraints
	public long[] sorted = new long[1000000];

	public void constructBITree(int array[], int length) {
		Arrays.fill(sorted, 0);
		for (int i = 0; i < length; i++)	//(int i = 1; i <= length; i++) ???
			bit[i] = 0;

		for (int i = 0; i < length; i++) {
			updateBIT(length, i, array[i]);
			updateSort(1000000, array[i], 1);
		}
	}

	public long getSum(int num) { 
		long sum = 0;
		num = num + 1; 
		while(num > 0) {    
			sum += (long)bit[num]; 
			num -= num & (-num); 
		}
		return sum;
	}

	public void updateBIT(int length, int index, int value) { 
		index = index + 1; 

		while (index <= length) { 
			bit[index] += (long)value; 
			index += index & (-index); 
		}
	}
	
	public void updateSort(int length, int index, int value) {
		index = index + 1; 

		while (index <= length) { 
			sorted[index] += value; 
			index += index & (-index); 
		}
	}

	public long getLower(int num) {
		long sum = 0;
		num = num + 1;
		while(num > 1) {	//num > 0?
			sum += (long)sorted[num];
			num -= num & (-num);
		}
		return sum;
	}
}