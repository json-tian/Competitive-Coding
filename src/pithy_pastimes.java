import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class pithy_pastimes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int hobbies = Integer.parseInt(input.readLine());
		
		String[] allHobbies = input.readLine().split(" ");
		
		for (int i = 0; i < allHobbies.length; i ++) {
			if (allHobbies[i].length() > 10) {
				hobbies--;
			}
		}
		System.out.println(hobbies);
	}
}