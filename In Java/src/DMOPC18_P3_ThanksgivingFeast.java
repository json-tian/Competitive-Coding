import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class DMOPC18_P3_ThanksgivingFeast {

	//TOO SLOW!!!!!
	public static int goal;
	public static ArrayList<Integer> shops = new ArrayList<>();
	public static ArrayList<Integer> minDistance = new ArrayList<>();

	public static int nodes;   // No. of vertices 
	public static LinkedList<Integer> adj[]; //Adjacency Lists 

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = in.readLine().split(" ");

		nodes = Integer.parseInt(temp[0]);
		adj = new LinkedList[nodes]; 
		
		for (int i = 0; i < nodes; i++) 
			adj[i] = new LinkedList<Integer>(); 

		int roads = Integer.parseInt(temp[1]);
		int gifts = Integer.parseInt(temp[2]);
		int home = Integer.parseInt(temp[3])-1;
		goal = Integer.parseInt(temp[4])-1;

		String[] giftsBuildings = in.readLine().split(" ");

		for (int i = 0; i < gifts; i ++)
			shops.add(Integer.parseInt(giftsBuildings[i])-1);

		for (int i = 0; i < roads; i ++) {
			String[] temp1 = in.readLine().split(" ");
			addEdge(Integer.parseInt(temp1[0])-1, Integer.parseInt(temp1[1])-1);
		}
		
		for (int i = 0; i < nodes; i ++)
			minDistance.add(0);

		bfs(home);

		ArrayList<Integer> minStart = new ArrayList<>();
		
		for (int i = 0; i < gifts; i ++)
			minStart.add(minDistance.get(shops.get(i)));

		Collections.fill(minDistance, 0);

		bfs(goal);
		
		for (int i = 0; i < gifts; i ++)
			minStart.set(i, minStart.get(i) + minDistance.get(shops.get(i)));
		
//		for (int i = 0; i < nodes; i ++)
//			System.out.println(minStart.get(i));
		
		//System.out.println(Collections.min(minStart));

		//BFS - find shortest route
		//DFS - exhaust all possibilities (count numWays)

		//DFS
		//		for (int i = 0; i < node[currentNode].connect.size(); i ++) {
		//
		//			int goingTo = node[currentNode].getConnect(i);
		//			int distance = currentDistance + 1;
		//
		//			if (node[goingTo].getLowestD() > distance) {
		//				node[goingTo].setLowestD(distance);
		//				dfs(goingTo, distance);
		//			}
		//		}
		
		System.out.println(Collections.min(minStart));
		
	}

	// Function to add an edge into the graph 
	static void addEdge(int v,int w) { 
		adj[v].add(w); 
	}

	// breadth-first search from a single source
    private void bfs(Graph G, int s) {
        Queue<Integer> q = new Queue<Integer>();
        for (int v = 0; v < G.V(); v++)
            distTo[v] = INFINITY;
        distTo[s] = 0;
        marked[s] = true;
        q.enqueue(s);

        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }
}
