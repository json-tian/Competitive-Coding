import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P0 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] token = input.readLine().split(" ");
		int radius = Integer.parseInt(token[0]);
		int x = Integer.parseInt(token[1]);
		int y = Integer.parseInt(token[2]);
		
		int smallest = 101;
		int xcoord = 0;
		int ycoord = 0;
		for (int i = 0; i < 3; i ++) {
			token = input.readLine().split(" ");
			if (Integer.parseInt(token[2]) < smallest) {
				smallest = Integer.parseInt(token[2]);
				xcoord = Integer.parseInt(token[0]);
				ycoord = Integer.parseInt(token[1]);
			}
		}
		
		double distance = Math.sqrt(Math.pow(y - ycoord, 2) + Math.pow(x - xcoord, 2));
		if (radius <= distance) {
			System.out.println("Time to move my telescope!");
		} else {
			System.out.println("What a beauty!");
		}

	}

}
