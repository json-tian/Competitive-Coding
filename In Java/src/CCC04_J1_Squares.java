import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC04_J1_Squares {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(input.readLine());
		
		for (int i = 1; i < 10000; i ++) {
			if ((i * i) > num) {
				System.out.println("The largest square has side length " + (i-1) + ".");
				break;
			}
		}
	}
}
