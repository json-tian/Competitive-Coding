import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bool {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = input.readLine().split(" ");
		
		if (line.length % 2 == 0) {
			if (line[line.length-1].equals("True"))
				System.out.print("False");
			else {
				System.out.print("True");
			}
		} else {
			System.out.print(line[line.length-1]);
		}

	}

}
