import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(input.readLine());
		int[] a = new int[n];
		int[] b = new int[n];
		HashMap<Integer, Integer> diff = new HashMap<>();
		String[] temp = input.readLine().split(" ");
		String[] temp1 = input.readLine().split(" ");
		for (int i = 0; i < n; i ++) {
			a[i] = Integer.parseInt(temp[i]);
			b[i] = Integer.parseInt(temp1[i]);
			if (a[i] - b[i] > 0)
				diff.put(i, a[i] - b[i]);
		}
		int sum = 0;
		if (diff.size() % 2 == 0) {
			for (int i = 0; i < diff.size(); i ++) {
				sum += b[(int)diff.keySet().toArray()[i]];
				a[(int)diff.keySet().toArray()[i]] = 0;
			}
		} else {
			int min = 1001;
			int index = 0;
			for (int i = 0; i < diff.size(); i ++) {
				if (diff.get((int)diff.keySet().toArray()[i]) < min) {
					min = diff.get((int)diff.keySet().toArray()[i]);
					index = (int)diff.keySet().toArray()[i];
				}
			}
			for (int i = 0; i < diff.size(); i ++) {
				if ((int)diff.keySet().toArray()[i] != index) {
					sum += b[(int)diff.keySet().toArray()[i]];
					a[(int)diff.keySet().toArray()[i]] = 0;
				}
			}
		}
		
		for (int i = 0; i < n; i ++) {
			sum += a[i];
		}
		
		System.out.println(sum);
		
	}

}
