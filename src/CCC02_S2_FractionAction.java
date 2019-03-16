import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC02_S2_FractionAction {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(input.readLine());
		int dem = Integer.parseInt(input.readLine());
		int wholeCounter = 0;

		while (num >= dem) {
			num -= dem;
			wholeCounter++;
		}
		if (wholeCounter != 0) {
			if (num == 0)
				System.out.println(wholeCounter);
			else {
				int gcd = gcd(num, dem);
				num = num / gcd;
				dem = dem / gcd;
				System.out.println(wholeCounter + " " + num + "/" + dem);
			}
		} else {
			if (num == 0)
				System.out.println(0);
			else {
				int gcd = gcd(num, dem);
				num = num / gcd;
				dem = dem / gcd;
				System.out.println(num + "/" + dem);
			}
		}
	}


	public static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else 
			return gcd(y, x % y);
	}

}
