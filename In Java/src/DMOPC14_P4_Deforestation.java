import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*Python OPTIMAL SOLUTION
 * import sys
input = sys.stdin.readline

N = int(input())

masses = []
for tree in range(N):
    masses.append(int(input()))

prefix = [0] * N
prefix[0] = masses[0]

for i in range(1, N):
    prefix[i] = prefix[i - 1] + masses[i]


Q = int(input())
for q in range(Q):
    a, b = map(int, input().split())
    # sum of masses[a:b]
    print(prefix[b] - prefix[a] + masses[a])
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class DMOPC14_P4_Deforestation {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		int trees = Integer.parseInt(input.readLine());
		int[] treeLengths = new int[trees];
		for (int i = 0; i < trees; i ++) {
			treeLengths[i] = Integer.parseInt(input.readLine());
		}
		
        //FenwickTree Solution
		Tree tree = new Tree();
        Tree.constructBITree(treeLengths, trees); 
		
		int cases = Integer.parseInt(input.readLine());
		
		for (int i = 0; i < cases; i ++) {
			String[] temp = input.readLine().split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			if (a != 0)
				System.out.println(tree.getSum(b) - tree.getSum(a-1)); 
			else
				System.out.println(tree.getSum(b)); 
			
			/* TLE Solution
			String[] temp = input.readLine().split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			int woodCut = 0;
			for (int j = a; j < b+1; j ++) {
				woodCut += treeLengths[j];
			}
		
			System.out.println(woodCut);
			*/
		}
	}
}

class Tree {
	public static int[] bit = new int[1000000];	//Maximum based on constraints

	public static void constructBITree(int array[], int length) { 
        for (int i = 1; i <= length; i++) 
            bit[i] = 0; 
      
        for (int i = 0; i < length; i++) 
            updateBIT(length, i, array[i]); 
    }
	
    public int getSum(int num) { 
        int sum = 0;
        num = num + 1; 
        while(num > 0) {    
            sum += bit[num]; 
            num -= num & (-num); 
        } 
        return sum; 
    } 
   
    public static void updateBIT(int length, int num, int value) { 
        num = num + 1; 

        while (num <= length) { 
        	bit[num] += value; 
        	num += num & (-num); 
        } 
    } 
}