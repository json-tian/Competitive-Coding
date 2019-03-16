import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC15_S2_HappyorSad {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String sentence = input.readLine();
		int smile = 0;
		int sad = 0;
		
		for (int i = 0; i < (sentence.length()-2); i++) {
			if (sentence.substring(i, i + 3).equals(":-)"))
				smile++;
			else if (sentence.substring(i, i + 3).equals(":-("))
				sad++;			
		}
		if (smile > sad)
			System.out.println("happy");
		else if (sad > smile)
			System.out.println("sad");
		else if (sad == smile && sad != 0)
			System.out.println("unsure");
		else
			System.out.println("none");
	}
}