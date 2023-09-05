


import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		

		int k = gcd(n, m);
		
		
		
		System.out.println(n/k+":"+m/k);
	}
	static int a;
	static int b;
	public static int gcd(int n, int m) {
		a=n;
		b=m;
		
		while(b>0) {
			int tmp = a;
			a = b;
			b = tmp%b;
		}
		return a;
	}
	
}