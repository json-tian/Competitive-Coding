import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC15_J5_PiDay {

	public static int numWays = 0;
	public static int pieces;
	public static int people;
	
	//Passed 10/15 TLE
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		pieces = Integer.parseInt(in.readLine());
		people = Integer.parseInt(in.readLine());
		
		givePie(0, 1, 0);
		System.out.println(numWays);
		
	}
	
	public static void givePie(int total, int prev, int persons) {
		if (persons == people) {
			if (total == pieces) {
				numWays ++;
			}
		} else {
			int add = 0;
			while ((((people - persons) * (prev + add)) + total) <= pieces) {
				givePie(total + (prev + add), (prev + add), persons + 1);
				add++;
			}
		}
	}

}
