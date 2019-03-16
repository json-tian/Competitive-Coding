import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC96_S1_DeficientPerfectAbundant {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int problems = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < problems; i ++) {
			int num = Integer.parseInt(input.readLine());
			int total = 0;
			for (int j = 1; j < (num/2)+1; j ++) {
				if ((num % j) == 0) {
					total += j;
				}
			}
			if (total > num) {
				System.out.println(num + " is an abundant number.");
			} else if (num > total) {
				System.out.println(num + " is a deficient number.");
			} else {
				System.out.println(num + " is a perfect number.");	
			}
		}

	}

}
