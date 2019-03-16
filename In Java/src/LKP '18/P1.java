import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1 {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] line = input.readLine().split(" ");
		String[] denom = input.readLine().split(" ");
		
		int num = Integer.parseInt(line[0]);
		int goal = Integer.parseInt(line[1]);
		int sum = 0;
		int coins = 0;
		for (int i = num-1; i >= 0; i --) {
			int current = Integer.parseInt(denom[i]);
			while ((sum + current) <= goal) {
				sum += current;
				coins++;
			}
		}
		
		if (sum == goal)
			System.out.println(coins);
		else
			System.out.println(-1);
	}

}
