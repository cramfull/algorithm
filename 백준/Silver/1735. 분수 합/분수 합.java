

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A1 = Integer.parseInt(st.nextToken());
		int B1 = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int A2 = Integer.parseInt(st.nextToken());
		int B2 = Integer.parseInt(st.nextToken());
		long gcd = gcd(B1,B2);
		long result2 = gcd*B1*B2;
		long result1 = A1*(result2/B1)+A2*(result2/B2);
		long k = gcd(result1,result2);
		if(k!=1) {
			result2/=k;
			result1/=k;
		}
		
		System.out.println(result1+" "+ result2);
		
		
	}
	
	public static long gcd(long x, long y) {
		
		long a=Math.max(x, y);
		long b= Math.min(x, y);
		long temp;
		
		while(b!=0) {
			temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	
}