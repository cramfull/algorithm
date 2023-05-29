import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;



public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int B = Integer.parseInt(str.nextToken());
		
		while(N!=0) {
			int tmp = N;
			N = N/B;
			tmp %=B;
			
			if(tmp>=0 && tmp<=9) {
				sb.append(tmp);
			}else {
				tmp = tmp+55;
				sb.append((char)tmp);
			}
		}
		sb.reverse();
		System.out.println(sb.toString());
		
		
		
		
		
	}
}