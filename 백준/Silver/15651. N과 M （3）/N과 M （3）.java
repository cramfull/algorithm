
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
	
	static int [] arr;
	static int N,M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[M+1];
		backTracking(0,N,M, sb);
		
		System.out.println(sb.toString());
		
		
		
	}
	static void backTracking(int x, int N , int M, StringBuilder sb) {
		if(x==M) {
			for(int i=0;i<M;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}else {
			for(int i=1; i<=N; i++) {
				arr[x] = i;
				backTracking(x+1, N, M, sb);
			}
		}
		
	}
	
}