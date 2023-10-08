
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;



public class Main {
	
	static int [] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		arr = new int[M+1];
		
		
		backtracking(1, 0, N, M);
		System.out.println(sb.toString());
		
		
		
	}
	
	static void backtracking(int at, int x, int N, int M) {
		if(x==M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}else {
			for(int i=at; i<=N;i++) {
				arr[x] = i;
				backtracking(i, x+1, N, M);
				
				
			}
			
			
		}
	}
	
	
}