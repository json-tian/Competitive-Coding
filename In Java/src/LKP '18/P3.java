import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P3 {

	public static Node [] node;
	public static ArrayList<Integer> reached = new ArrayList<>();
	public static int start;
	public static int end;
	public static int minutes;
	public static int lowest = 1000000;

	public static void dfs (int current, long currentDistance, int level) {

		int sizeOfConnections = node[current].connect.size();
		
		for(int i = 0 ; i < sizeOfConnections; i ++) {

			int goingto =  node[current].getC(i);

			long traveldistance = node[current].getCD(i);
			
			if (((currentDistance + traveldistance) < minutes) && current != end) {
				if (level < lowest && level >= node[current].getPassages(i)) {
					//node[goingto].setLowestD(currentDistance + traveldistance);
					dfs(goingto, currentDistance + traveldistance, level);
				} else {
					if (node[current].getPassages(i) < lowest && level < lowest)
					//node[goingto].setLowestD(currentDistance + traveldistance);
						dfs(goingto, currentDistance + traveldistance, node[current].getPassages(i));
				}
			} else {
				if ((currentDistance < minutes) && (current == end)) {
					reached.add(level);
					lowest = Collections.min(reached);
				}
			}
		}
	}

	public static void main(String[] args) {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			String [] tokens = in.readLine().split(" ");
			int stations = Integer.parseInt(tokens[1]);
			int nodes = Integer.parseInt(tokens[0]);

			node = new Node[nodes];

			for (int i = 0 ; i < nodes; i++) {
				node[i] = new Node();
			}

			int node1;
			int node2;
			int val;
			for(int i = 0 ; i < stations; i++) {
				tokens = in.readLine().split(" ");

				node1 = Integer.parseInt(tokens[0])-1;
				node2 = Integer.parseInt(tokens[1])-1;
				val = Integer.parseInt(tokens[2]);

				//update node1 with distance val
				node[node1].addC(node2);
				node[node1].addCD(val);
				node[node1].addPassages(i);

				//update node2 with distance val
				node[node2].addC(node1);
				node[node2].addCD(val);
				node[node2].addPassages(i);

			}

			tokens = in.readLine().split(" ");
			start = Integer.parseInt(tokens[0])-1;
			end = Integer.parseInt(tokens[1])-1;
			minutes = (Integer.parseInt(tokens[2]));

			dfs(start, 0, 0);

			if (reached.size() > 0) {
				System.out.print(Collections.min(reached)+1);
			} else {
				System.out.print(-1);
			}

		}catch(Exception E) {
			E.printStackTrace();
		}
	}

}

class Node{

	public ArrayList<Integer> connect = new ArrayList<>();
	public ArrayList<Long> connectD = new ArrayList<>();
	public ArrayList<Integer> passages = new ArrayList<>();

	public Node() {

	}

	public void addC (int i) {
		this.connect.add(i);
	}

	public int getC(int i) {
		return this.connect.get(i);
	}

	public void addPassages (int i) {
		this.passages.add(i);
	}

	public int getPassages(int i) {
		return this.passages.get(i);
	}

	public void addCD (long i) {
		this.connectD.add(i);
	}

	public long getCD(int i) {
		return this.connectD.get(i);
	}

}