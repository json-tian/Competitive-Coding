import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC18_J1_Telemarketer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int first = Integer.parseInt(input.readLine());
		int second = Integer.parseInt(input.readLine());
		int third = Integer.parseInt(input.readLine());
		int fourth = Integer.parseInt(input.readLine());

		if ((first == 8 || first == 9) && (fourth == 8 || fourth == 9) && (third == second))
			System.out.print("ignore");
		else
			System.out.print("answer");
	}

}
