import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class A_Plus_B_Hard {
//HALF COMPLETE
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int problems = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < problems; i ++) {
			String answer = "";
			String[] temp = in.readLine().split(" ");
			String a = temp[0];
			String b = temp[1];
			String state = "";
			int carryOver = 0;
			
			if (a.charAt(0) != '-' && b.charAt(0) != '-') {
				state = "positive";
			} else if (a.charAt(0) == '-' && b.charAt(0) == '-') {
				state = "negative";
				a = a.substring(1);
				b = b.substring(1);
			} else if (a.charAt(0) == '-') {
				state = "subtract";
				a = a.substring(1);
			} else if (b.charAt(0) == '-') {
				state = "subtract";
				String temp1 = b;
				b = a;
				a = temp1;
				a = a.substring(1);
			}
			
			if (state.equals("positive") || state.equals("negative")) {
				while (a.length() > 0 || b.length() > 0) {
					if (a.length() > 0 && b.length() > 0) {
						int total = Integer.parseInt(a.substring(a.length()-1, a.length())) + Integer.parseInt(b.substring(b.length()-1, b.length())) + carryOver;
						answer = String.valueOf(total % 10) + answer;
						if (total >= 10)
							carryOver = (total - (total % 10)) / 10;
						else
							carryOver = 0;
						a = a.substring(0, a.length()-1);
						b = b.substring(0, b.length()-1);
					} else {
						if (b.length() > 0) {
							a = b;
							b = "";
						}
						if (a.length() > 0) {
							int total = Integer.parseInt(a.substring(a.length()-1, a.length())) + carryOver;
							answer = String.valueOf(total % 10) + answer;
							if (total >= 10)
								carryOver = (total - (total % 10)) / 10;
							else
								carryOver = 0;
							a = a.substring(0, a.length()-1);
						}
					}
				}
				
				if (state.equals("positive")) {
					if (carryOver != 0)
						System.out.println((String.valueOf(carryOver) + answer));
					else
						System.out.println(answer);
				} else {
					if (carryOver != 0)
						System.out.println("-" + (String.valueOf(carryOver) + answer));
					else
						System.out.println("-" + answer);
				}
			} else {
				//Subtraction. b - a
				BigInteger x = new BigInteger(b);
				BigInteger y = new BigInteger(a);
				System.out.println(x.subtract(y));
			}
		}

	}

}
