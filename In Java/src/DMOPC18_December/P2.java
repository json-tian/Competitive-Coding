import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class P2 {

	private static int max = 0;
	private static int goal = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int tasks = Integer.parseInt(input.readLine());
		String[] tokens = input.readLine().split(" ");
		int[] time = new int[tasks];
		for (int i = 0; i < tasks; i ++) {
			time[i] = (Integer.parseInt(tokens[i]));
			goal += Integer.parseInt(tokens[i]);
		}
		Arrays.sort(time);
		boolean even = true;
		if (goal % 2 == 0) {
			goal /= 2;
		} else {
			even = false;
			goal = (goal - 1) / 2;
		}

		subsetSums(time, 0, time.length-1, 0);

		if (even)
			System.out.println((goal - max) * 2);
		else
			System.out.println(((goal - max) * 2) + 1);
	}

	static void subsetSums(int[] array, int l, int r, int sum) { 
		if (l > r && sum <= goal && sum > max) { 
			max = sum;
			return; 
		} else if (l > r || sum > goal) {
			return;
		}
		
		if (sum + array[l] <= goal) {
			subsetSums(array, l + 1, r, sum + array[l]);
			subsetSums(array, l + 1, r, sum);
		}
	} 
}
