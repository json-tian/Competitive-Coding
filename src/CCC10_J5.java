import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC10_J5 {

	static int endX;
	static int endY;
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] start = input.readLine().split(" ");
		String[] end = input.readLine().split(" ");
		int startX = Integer.parseInt(start[0]);
		int startY = Integer.parseInt(start[1]);
		endX = Integer.parseInt(end[0]);
		endY = Integer.parseInt(end[1]);
		knightHop(startX, startY, 0);
	}
	
	public static int knightHop(int startX, int startY, int steps) {
		if (startX == endX && startY == endY)
			return steps;
		
		if ()
		return steps;
		
	}

}
