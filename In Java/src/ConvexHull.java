import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConvexHull {
	
	public static Island [] island;
	public static int hull;
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String [] temp = input.readLine().split(" ");
		hull = Integer.parseInt(temp[0]);
		int islands = Integer.parseInt(temp[1]);
		island = new Island[islands];
		
		for(int i = 0; i < islands ; i ++) {
			island[i] = new Island();
		}
		
		int routes = Integer.parseInt(temp[2]);
		int island1;
		int island2;
		int time;
		int damage;
			
		for(int i = 0 ; i < routes ; i++) {
			temp = input.readLine().split(" ");

			island1 = Integer.parseInt(temp[0])-1;
			island2 = Integer.parseInt(temp[1])-1;
			time = Integer.parseInt(temp[2]);
			damage = Integer.parseInt(temp[3]);

			island[island1].addC(island2);
			island[island1].addCD(damage);
			island[island1].addCT(time);

			island[island2].addC(island1);
			island[island2].addCD(damage);
			island[island2].addCT(time);
		}
		temp = input.readLine().split(" ");
		travel(Integer.parseInt(temp[0])-1);
		
		if (island[Integer.parseInt(temp[1])-1].getLowestT() < 999999999)
			System.out.println(island[Integer.parseInt(temp[1])-1].getLowestT());
		else
			System.out.println(-1);
	}
	
	public static void travel (int first) {
		island[first].setLowestD(0);
		island[first].setLowestT(0);
		
		ArrayList<Integer> q = new ArrayList<Integer>();
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> t = new ArrayList<Integer>();
		
		d.add(0);
		t.add(0);
		q.add(first);
		
		while (q.isEmpty() == false) {
			int current = q.get(0);
			int currentD = d.get(0);
			int currentT = t.get(0);
			
			q.remove(0);
			d.remove(0);
			t.remove(0);
			
			int size = island[current].connect.size();	
			
			for(int i = 0; i<size; i++) {
				if(currentD + island[current].getCD(i) < hull) {
					if(currentD + island[current].getCD(i) < island[island[current].getC(i)].getLowestD() || currentT+island[current].getCT(i) < island[island[current].getC(i)].getLowestT()) {
						island[island[current].getC(i)].setLowestD(Math.min(island[island[current].getC(i)].getLowestD(), currentD+island[current].getCD(i)));
						island[island[current].getC(i)].setLowestT(Math.min(island[island[current].getC(i)].getLowestT(), currentT+island[current].getCT(i)));
						
						q.add(island[current].getC(i));
						t.add(currentT+island[current].getCT(i));
						d.add(currentD+island[current].getCD(i));
					}
				}
			}
		}
	}
}

class Island {
	public int lowestT = 999999999;
	public int lowestD = 999999999;
	public ArrayList <Integer> connect = new ArrayList<Integer>();
	public ArrayList <Integer> connectT = new ArrayList<Integer>();
	public ArrayList <Integer> connectD = new ArrayList<Integer>();

	public Island() {
	}
	
	public int getLowestT() {
		return lowestT;
	}
	public void setLowestT(int lowestT) {
		this.lowestT = lowestT;
	}
	public int getLowestD() {
		return lowestD;
	}
	public void setLowestD(int lowestD) {
		this.lowestD = lowestD;
	}
	public void addC (int i) {
		this.connect.add(i);
	}
	public int getC(int i) {
		return this.connect.get(i);
	}
	public void addCT (int i) {
		this.connectT.add(i);
	}
	public int getCT(int i) {
		return this.connectT.get(i);
	}
	public void addCD (int i) {
		this.connectD.add(i);
	}
	public int getCD(int i) {
		return this.connectD.get(i);
	}
}