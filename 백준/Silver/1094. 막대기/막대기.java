
import java.io.*;

import java.util.*;
import java.util.Map.Entry;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String binaryN = Integer.toBinaryString(N);
		int sum = 0;
		for(int i=0; i<binaryN.length(); i++) {
			if(binaryN.charAt(i)=='1') {
				sum++;
			}
		}
		System.out.println(sum);
		
		
		
		
	}
	
}