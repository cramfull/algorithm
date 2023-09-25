

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		
		long sum = 0;
		long result=0;
		
		
		
		
		for(long i=0;i<N;i++) {
			sum+=2*i+1;
			if(sum>=N) {
				result = i;
				break;
			}
		}
		if(N==1) {
			System.out.println(1);
		}else {
		System.out.println(result);
		}
		
	}
}