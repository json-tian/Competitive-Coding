import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DMOPC18_P2_SUBTASK {

	//DOESNT WORK!?? WHY
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = input.readLine().split(" ");
		int people = Integer.parseInt(temp[2]);

		int[] persons = new int[people];
		String[] p = input.readLine().split(" ");
		for (int i = 0; i < people; i ++) {
			persons[i] = Integer.parseInt(p[i]);
		}
		Arrays.sort(persons);

		int cushions = 0;

		for (int i = people; i > 1; i --) {
			cushions += ((persons[i-1] - persons[i-2]) + 1);
			persons[i-2] = persons[i-1] + 1;
		}
		System.out.print(cushions);
	}

}
