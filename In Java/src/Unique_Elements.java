import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Unique_Elements {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int numbers = Integer.parseInt(input.readLine());
		ArrayList<Integer> unique = new ArrayList<>();
		int uniqueNumbers = 0;
		
		for (int i = 0; i < numbers; i ++) {
			int num = Integer.parseInt(input.readLine());
			if (!unique.contains(num)) {
				unique.add(num);
				uniqueNumbers++;
			}
		}
		
		System.out.println(uniqueNumbers);
	}

}
