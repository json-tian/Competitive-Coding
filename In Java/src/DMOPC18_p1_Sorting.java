import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DMOPC18_p1_Sorting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int size = Integer.parseInt(input.readLine());

		String[] numbers = input.readLine().split(" ");
		ArrayList<Integer> newNumbers = new ArrayList<>();

		int prevNum = -1;
		boolean possible = true;
		int zero = -1;

		for (int i = 0; i < size; i ++) {
			int current = Integer.parseInt(numbers[i]);
			if (current != 0) {
				newNumbers.add(current);
				if (current < prevNum) {
					possible = false;
					break;
				}
				prevNum = current;
			} else {
				if (zero == -1) {
					if (i < (size-1)) {
						zero = Integer.parseInt(numbers[i+1]);
					}
				} else {
					if (i < (size-1)) {
						
					} else {
						
					}
				}
			}
		}
		if (possible == false)
			System.out.println("NO");
		else
			System.out.println("YES");

	}

}
