

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		if(a<b) {
			long temp = a;
			a =b;
			b = temp;
		}
		
		
		long gcd = gcd(a, b);
		
		
		
		System.out.println((a*b)/gcd);
		
		
	}
	
	static long gcd(long a, long b) {
		long r = 0;
		while(b!=0) {
			r = b;
			b = a%b;
			a = r;
		}
		return a;
		
	}
	
}