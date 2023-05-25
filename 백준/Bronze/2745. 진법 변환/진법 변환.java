
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		String N = str.nextToken();
		int B = Integer.parseInt(str.nextToken());
		
		int idx = N.length()-1;
		int num =0;
		long result = 0;
		for(int i=N.length()-1; i>=0; i--) {
			char c = N.charAt((N.length()-1)-i);
			if(c>='A' && c<='Z') {
				num = (int)c - 'A'+10; 
			}else {
				num = (int)c - '0';
			}
			result += num*Math.pow(B, i);
			
		}
		System.out.println(result);
		
		
		
		
		
		
		
	}
}
