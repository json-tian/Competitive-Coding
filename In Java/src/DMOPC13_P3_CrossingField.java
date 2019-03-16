import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DMOPC13_P3_CrossingField {

	public static int[][] map;
	public static int size;
	public static int elevation;
	
	//NOT FINISHED
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = input.readLine().split(" ");
		size = Integer.parseInt(temp[0]);
		elevation = Integer.parseInt(temp[1]);
		
		map = new int[size][size];
		
		for (int i = 0; i < size; i ++) {
			temp = input.readLine().split(" ");
			for (int j = 0; j < size; j ++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		for (int i = 0; i < size; i ++) {
			for (int j = 0; j < size; j ++) {
				if ((i != size) && (map[i+1][j] <= (map[i][j] + elevation))) {
					
				}
				if ((i > 0) && (map[i-1][j] <= (map[i][j] + elevation))) {
					
				}
				if ((j != size) && (map[i][j+1] <= (map[i][j] + elevation))) {
					
				}
				if ((j != size) && (map[i][j-1] <= (map[i][j] + elevation))) {
					
				}
			}
		}
		
		search(0, 0);

	}
	
	public static void search(int row, int column) {
		if (row == size && column == size) {
			System.out.println("yes");
		} else {
				
		}
	}
}
class Node2 {
	
	public ArrayList<Integer> connect = new ArrayList<Integer>();
	public int lowestD = 1000000000;

	
	public Node2() {
		
	}
	
	public void addConnect(int i) {
		this.connect.add(i);
	}
	public int getConnect(int i) {
		return this.connect.get(i);
	}
	public int getLowestD() {
		return lowestD;
	}
	public void setLowestD(int lowestD) {
		this.lowestD = lowestD;
	}
}