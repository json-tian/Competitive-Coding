import java.util.Scanner;

public class Next_Prime {
//WA?!?
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int target = input.nextInt();
		System.out.println(findFactors(target));
		input.close();
	}
	
	public static int findFactors(int num) {
		for (int i = 2; i < ((num/2)+1); i ++) {
			if (num % i == 0) {
				return findFactors(num+1);
			}
		}
		return num;
	}
}
