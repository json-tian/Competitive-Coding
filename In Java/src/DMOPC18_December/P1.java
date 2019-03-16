import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int sequences = Integer.parseInt(input.readLine());
		
		double massx = Double.parseDouble(input.readLine());
		
		String[] tokens;
		double mean = 0;
		for (int i = 0; i < sequences; i ++) {
			tokens = input.readLine().split(" ");
			int stars = Integer.parseInt(tokens[0]);
			
			double current = massx;
			for (int k = 1; k < stars + 1; k ++) {
				current += Double.parseDouble(tokens[k]);
			}
			mean += current;
		}
		
		mean /= sequences;
		System.out.println(mean);

	}

}
