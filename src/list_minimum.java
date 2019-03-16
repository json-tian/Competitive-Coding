import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class list_minimum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(input.readLine());
		int[] array = new int[size];
		for (int i = 0; i < size; i ++) {
			array[i] = Integer.parseInt(input.readLine());
		}
		Arrays.sort(array);
		for (int i = 0; i < size; i ++) {
			System.out.println(array[i]);
		}
	}
}
