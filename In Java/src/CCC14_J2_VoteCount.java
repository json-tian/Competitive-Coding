import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC14_J2_VoteCount {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int numVotes = Integer.parseInt(input.readLine());
		String votes = input.readLine();
		
		int b = 0;
		int a = 0;
		
		for (int i = 0; i < numVotes; i ++) {
			if (votes.charAt(i) == 'A')
				a++;
			else
				b++;
		}
		
		if (a > b)
			System.out.println("A");
		else if (b > a)
			System.out.println("B");
		else
			System.out.println("Tie");
	}

}
