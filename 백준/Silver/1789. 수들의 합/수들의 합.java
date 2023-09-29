
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N = Long.parseLong(br.readLine());
		StringBuilder sb = new StringBuilder();
		long k = 0;
		long sum =0;
		while(sum<=N) {
			k++;
			sum = k*(k+1)/2;
		}
		sb.append(k-1);
		System.out.println(sb.toString());
		
	}
	
}