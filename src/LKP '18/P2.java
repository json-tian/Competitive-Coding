import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		long frogs = Long.parseLong(input.readLine());
		
		long sum = 0;
		if (frogs % 2 == 0) {
			sum = ((frogs / 2) * (frogs / 2)) * 2;
		} else {
			sum = (((frogs * (frogs+1)) / 2) - ((((frogs+1) / 2) * ((frogs+1) / 2)))) * 2;
		}
		
		System.out.println(sum);
	}

}
