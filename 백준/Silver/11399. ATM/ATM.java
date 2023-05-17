

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int [] Pi = new int [N];
		for(int i = 0 ; i<N; i++) {
			Pi[i]=Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(Pi);
		int sum=0;
		int result = 0;
		for(int i=0; i<N; i++) {
			sum += Pi[i];
			result += sum;
		}
		System.out.println(result);
		
		
	}
}