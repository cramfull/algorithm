

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int [][] arr = new int[100][100];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			colorPaper(arr, x, y);
		}
		int sum =0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				sum+=arr[i][j];
			}
		}
		
		System.out.println(sum);
		
		
		
		
		
	}
	public static void colorPaper(int [][] arr, int x, int y) {
		for(int i=x; i<x+10; i++) {
			for(int j=y; j<y+10; j++) {
				arr[i][j]=1;
			}
		}
	}
	
}