import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_Minus_B {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int problems = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < problems; i ++) {
			String[] temp = input.readLine().split(" ");
			long a = Long.parseLong(temp[0]);
			long b = Long.parseLong(temp[1]);
			System.out.println(a + b);
		}

	}

}
