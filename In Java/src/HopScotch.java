import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HopScotch {

	static int[] tree;
	static int[] power;
	static int squares;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		squares = Integer.parseInt(in.readLine());
		String[] tokens = in.readLine().split(" ");
		tree = new int[squares];
		power = new int[squares];
		for (int i = 0; i < tokens.length; i ++) {
			power[i] = Integer.parseInt(tokens[i]);
		}
		
		int operations = Integer.parseInt(in.readLine());
		
		String[] operation;
		for (int i = squares-1; i >= 0; i --) {
			update(i);
		}
		
		for (int i = 0; i < operations; i ++) {
			operation = in.readLine().split(" ");
			if (operation[0].equals("1")) {
				System.out.println(tree[Integer.parseInt(operation[1])]);
			} else {
				power[Integer.parseInt(operation[1])] = Integer.parseInt(operation[2]);
				for (int j = Integer.parseInt(operation[1]); j >= 0; j --) {
					update(j);
				}
			}
		}
	}
	public static void update(int index) {
		if (index + power[index] >= squares) {
			tree[index] = 1;
		} else {
			tree[index] = tree[index + power[index]] + 1;
		}
	}
}
