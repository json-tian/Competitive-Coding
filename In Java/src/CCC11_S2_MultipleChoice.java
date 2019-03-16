import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC11_S2_MultipleChoice {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int problems = Integer.parseInt(input.readLine());
		
		String[] questions = new String[problems];
		String[] solutions = new String[problems];
		int score = 0;
		
		for (int i = 0; i < problems; i ++) {
			solutions[i] = input.readLine();
		}
		
		for (int i = 0; i < problems; i ++) {
			questions[i] = input.readLine();
		}
		
		for (int i = 0; i < problems; i ++) {
			if (solutions[i].equals(questions[i])) {
				score ++;
			}
		}
		
		System.out.println(score);

	}

}
