import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DMOPC14_P3_NewStudents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int students = Integer.parseInt(input.readLine());
		
		int sum = 0;
		for (int i = 0; i < students; i ++) {
			sum += Integer.parseInt(input.readLine());
		}
		
		int newStudents = Integer.parseInt(input.readLine());
		for (int i = 0; i < newStudents; i ++) {
			sum += Integer.parseInt(input.readLine());
			students++;
			System.out.printf("%.4f\n", (double)sum / students);
		}
		

	}

}
