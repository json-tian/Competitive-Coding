import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

public class Binary_Indexed_Tree_Test {

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
			if (temp[0].equals("S")) {
				int a = Integer.parseInt(temp[1])-1;
				int b = Integer.parseInt(temp[2])-1;

				if (a != 0) {
					System.out.println(tree.getSum(b) - tree.getSum(a-1));
				} else
					System.out.println(tree.getSum(b)); 
			} else if (temp[0].equals("Q")) {
				System.out.println(tree.getLower(Integer.parseInt(temp[1])));
			} else if (temp[0].equals("C")) {
				int a = Integer.parseInt(temp[1])-1;
				int b = Integer.parseInt(temp[2]);
				tree.updateBIT(trees, a, (b - treeLengths[a]));
				tree.updateSort(1000000, treeLengths[a], -1);
				tree.updateSort(1000000, b, 1);
				treeLengths[a] = b;

			}
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