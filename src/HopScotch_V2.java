import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HopScotch_V2 {

	static int squares, operations, blocks, interval;
	static int[] val, block, right, pos, cnt;

	public static void main (String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		squares = Integer.parseInt(in.readLine());
		interval = (int)(Math.sqrt(squares));

		val = new int[squares];
		block = new int[squares];
		right = new int[squares];
		pos = new int[squares];
		cnt = new int[squares];

		String[] tokens = in.readLine().split(" ");
		
		operations = Integer.parseInt(in.readLine());

		for (int i = 0; i < squares; i++) {
			val[i] = Integer.parseInt(tokens[i]);
			block[i] = (i / interval);
			right[block[i]] = i;
			blocks = block[i];
		}
		
		int last = 0;
		for (int i = 0; i <= blocks; i++) {
			for (int j = right[i]; j >= last; j--) {
				if (j + val[j] > right[i]) {
					cnt[j] = 1;
					pos[j] = j + val[j];
				} else {
					cnt[j] = cnt[j + val[j]] + 1;
					pos[j] = pos[j + val[j]];
				}
			}
			last = right[i] + 1;
		}

		for (int i = 0; i < operations; i++) {
			tokens = in.readLine().split(" ");
			if (tokens[0].equals("1")) {
				System.out.println(query(Integer.parseInt(tokens[1])));
			} else {
				int index = Integer.parseInt(tokens[1]);
				int newValue = Integer.parseInt(tokens[2]);
				val[index] = newValue;
				int currentBlock = index / interval;
				last = 0;
				if (currentBlock != 0)
					last = right[currentBlock - 1] + 1;
				for (int j = index; j >= last; j--) {
					if (j + val[j] > right[currentBlock]) {
						cnt[j] = 1;
						pos[j] = j + val[j];
					} else {
						cnt[j] = cnt[j + val[j]] + 1;
						pos[j] = pos[j + val[j]];
					}
				}

			}
		}

	}
	
	public static int query(int index) {
		int total = 0;
		while (index < squares) {
			total += cnt[index];
			index = pos[index];
		}
		return total;
	}
}
