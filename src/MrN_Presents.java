import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class MrN_Presents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		//TOO SLOW!
		int queries = Integer.parseInt(input.readLine());
		LinkedList<Integer> students = new LinkedList<>();
		HashMap<Integer, Integer> location = new HashMap<>();
		for (int i = 0; i < queries; i ++) {
			String[] temp = input.readLine().split(" ");
			if (temp[0].equals("F")) {
				students.addFirst(Integer.parseInt(temp[1]));
				
			} else if (temp[0].equals("E")) {
				students.addLast(Integer.parseInt(temp[1]));
			} else {
				students.remove(students.indexOf(Integer.parseInt(temp[1])));
				//students.removeFirstOccurrence(Integer.parseInt(temp[1]));
			}
		}
		for (int i = 0; i < students.size(); i ++)
			System.out.println(students.get(i));
	}

}
