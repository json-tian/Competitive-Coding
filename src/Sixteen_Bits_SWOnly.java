import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//HOW TO DO THIS?!
public class Sixteen_Bits_SWOnly {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int cases = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < cases; i ++) {
			String[] temp = input.readLine().split(" ");
			if (((long) (Integer.parseInt(temp[0]) * Integer.parseInt(temp[1]))) != (Long.parseLong(temp[0]) * Long.parseLong(temp[1]))) {
				System.out.println("16 BIT S/W ONLY");
			} else {
				System.out.println("POSSIBLE DOUBLE SIGMA");
			}
		}

	}

}
