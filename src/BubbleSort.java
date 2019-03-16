import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int numbers = Integer.parseInt(input.readLine());
		int[] num = new int[numbers];
		String[] temp = input.readLine().split(" ");
		for (int i = 0; i < numbers; i ++) {
			num[i] = Integer.parseInt(temp[i]);
		}
		printArray(num);
		bubbleSort(num);

	}

	public static int [] swapNumbers (int [] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
		return array;
	}

	public static int[] bubbleSort (int [] array) {
		for (int index = 1; index <= array.length; index++) {
			boolean swapped = false;
			for (int index2 = 1; index2 <= array.length-1; index2++ ) {
				if(array[index2] < array[index2 - 1]) {
					swapNumbers(array, index2, index2 - 1);
					printArray(array);
					swapped = true;
				}
			}
			if (swapped = false)
				break;
		}
		return array;
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i ++) {
			System.out.print(array[i]);
			if (i != (array.length-1))
				System.out.print(" ");
		}
		System.out.println();
	}
}
