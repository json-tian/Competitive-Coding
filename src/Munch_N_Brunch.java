import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Munch_N_Brunch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 10; i ++) {
			int cost = Integer.parseInt(input.readLine());
			String[] percentages = input.readLine().split(" ");
			double year1 = Double.parseDouble(percentages[0]);
			double year2 = Double.parseDouble(percentages[1]);
			double year3 = Double.parseDouble(percentages[2]);
			double year4 = Double.parseDouble(percentages[3]);
			
			int students = Integer.parseInt(input.readLine());
			
			double budget = (year1 * students * 12) + (year2 * students * 10) + (year3 * students * 7) + (year4 * students * 5);
			
			if ((budget/2) >= cost)
				System.out.println("NO");
			else
				System.out.println("YES");
		}

	}

}
