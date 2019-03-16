import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CCC00_J1_Calendar {

	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = input.readLine().split(" ");
		int space = Integer.parseInt(temp[0]);
		int days = Integer.parseInt(temp[1]);
		
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		
		int rows;
		if ((days + space-1) % 7 != 0)
			rows = ((days + space - 1) / 7) + 1;
		else
			rows = ((days + space - 1) / 7);
			
		ArrayList<String> calendar = new ArrayList<>();
		
		for (int i = 0; i < space-1; i ++) {
			calendar.add("   ");
		}
		for (int i = 1; i < days+1; i ++) {
			if (i < 10) {
				calendar.add("  " + i);
			} else {
				calendar.add(" " + i);
			}
		}
		int column = 0;
		for (int i = 0; i < calendar.size(); i ++) {
			System.out.print(calendar.get(i));
			if (column != 6 && i != calendar.size()-1)
				System.out.print(" ");
			column ++;
			if (column == 7 || i == calendar.size()-1) {
				column = 0;
				System.out.println();
			}
		}

	}

}
