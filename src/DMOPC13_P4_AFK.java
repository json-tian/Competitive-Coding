import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DMOPC13_P4_AFK {

	public static ArrayList<Map>maps = new ArrayList<Map>();

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int cases = Integer.parseInt(in.readLine());

		for (int m = 0; m < cases; m++) {
			maps.clear();
			String[] temp = in.readLine().split(" ");
			int length = Integer.parseInt(temp[1]);
			int width = Integer.parseInt(temp[0]);

			int[][] map = new int[length][width];

			int MapCounter = 0;
			int start = 0;
			int end = 0;

			for (int i = 0; i < length; i ++) {
				String tempo = in.readLine();
				for (int j = 0; j < width; j ++) {
					String letter = tempo.substring(j, j+1);
					if (letter.equals("O") || letter.equals("C") || letter.equals("W")) {
						map[i][j] = MapCounter;
						maps.add(new Map());
						if (letter.equals("C"))
							start = MapCounter;
						else if (letter.equals("W")) {
							end = MapCounter;
						}
						MapCounter++;
					} else {
						map[i][j] = -1;
					}
				}
			}
			MapCounter = 0;
			for (int i = 0; i < length; i ++) {
				for (int j = 0; j < width; j ++) {
					if(map[i][j] != -1) {
						if (i > 0 && map[i-1][j] != -1)
							maps.get(MapCounter).addConnect(map[i-1][j]);
						if (j > 0 && map[i][j-1] != -1)
							maps.get(MapCounter).addConnect(map[i][j-1]);
						if (i < length-1 && map[i+1][j] != -1)
							maps.get(MapCounter).addConnect(map[i+1][j]);
						if (j < width-1 && map[i][j+1] != -1)
							maps.get(MapCounter).addConnect(map[i][j+1]);
						MapCounter++;
					}
				}
			}

			maps.get(start).setLowestD(0);
			dfs(start, 0);

			int answer = maps.get(end).getLowestD();

			if (answer == -1 || answer >= 60) {
				System.out.println("#notworth");
			} else {
				System.out.println(answer);
			}
		}

	}

	public static void dfs(int start, int currentD) {

		int sizeConnection = maps.get(start).connect.size();

		for (int i = 0; i < sizeConnection; i ++) {
			int goingTo = maps.get(start).connect.get(i);

			int distanceAfterTravel = currentD + 1;

			int maxDistance = maps.get(goingTo).getLowestD();

			if (distanceAfterTravel < maxDistance && distanceAfterTravel <= 60) {
				maps.get(goingTo).setLowestD(distanceAfterTravel);
				dfs(goingTo, distanceAfterTravel);
			}
		}
	}

}

class Map {

	public int lowestD = 1000000000;
	public ArrayList<Integer> connect = new ArrayList<Integer>();

	public Map() {

	}

	public int getLowestD() {
		return lowestD;
	}
	public void setLowestD(int lowestD) {
		this.lowestD = lowestD;
	}
	public Integer getConnect(int i) {
		return connect.get(i);
	}
	public void addConnect(int i) {
		connect.add(i);
	}
}