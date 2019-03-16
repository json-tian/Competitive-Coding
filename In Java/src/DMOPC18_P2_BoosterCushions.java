import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DMOPC18_P2_BoosterCushions {

	//DOESNT WORK!?? WHY

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = input.readLine().split(" ");
		int rows = Integer.parseInt(temp[0]);
		int columns = Integer.parseInt(temp[1]);
		int people = Integer.parseInt(temp[2]);
		
		int[] persons = new int[people];
		String[] p = input.readLine().split(" ");
		for (int i = 0; i < people; i ++) {
			persons[i] = Integer.parseInt(p[i]);
		}
		Arrays.sort(persons);
		
		int minColumns = columns;
		for (int i = columns; i > 0; i --) {
			if ((i * rows) >= people) {
				minColumns = i;
			} else
				break;
		}
		
		int[][] seating = new int[rows][minColumns];
		long cushions = 0;
		
		Outerloop:
		for (int i = 0; i < rows; i ++) {
			for (int j = 0; j < minColumns; j ++) {
				if (people == 0)
					break Outerloop;
				seating[i][j] = persons[people-1];
				if (i > 0) {
					if (seating[i-1][j] - seating[i][j] >= 0) {
						cushions += (long)(seating[i-1][j] - seating[i][j] + 1);
						seating[i][j] = seating[i-1][j] + 1;
					}
				}
				people--;
			}
		}
		
		System.out.println(cushions);
	}

}
