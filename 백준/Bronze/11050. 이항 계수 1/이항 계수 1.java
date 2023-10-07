
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;



public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(str.nextToken());
		int r = Integer.parseInt(str.nextToken());
		
		
		
		
		
		System.out.println(combination(n,r));
	}
	
	static int combination(int n, int r) {
		if(n==r||r==0) {
			return 1;
		}else {
			return combination(n-1,r-1)+combination(n-1,r);
		}
		
	}
	
	
}