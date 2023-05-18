
import java.util.Scanner;




public class Main {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		
		for(int i=0; i<T; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			int lcm = (a*b)/ecud(a,b);
			
			System.out.println(lcm);
			
			
		}
	}
	
	static int ecud(int a, int b) {
		while(a!=0) {
			int tmp= a;
			a = b%a;
			b = tmp;
		}
		return b;
	}
}
	
	
