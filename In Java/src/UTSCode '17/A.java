import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = input.readLine().split(" ");
		String[] temp2 = input.readLine().split(" ");
		
		double p = Double.parseDouble(temp[0]);
		double m = Double.parseDouble(temp[1]);
		double t = Double.parseDouble(temp[2]);
		double d = Double.parseDouble(temp[3]);
		
		double armor = Double.parseDouble(temp2[0]);
		double mr = Double.parseDouble(temp2[1]);
		
		double pd = d * p;
		double md = d * m;
		double td = d * t;
		
		double total = td + (pd *(100/(100+armor))) + (md * (100/(100+mr)));
		
		System.out.println((int) total);

	}

}
