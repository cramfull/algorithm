	
import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int [] arr;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		arr = new int[M];
		sb = new StringBuilder();
		
		backTracking(0,1);
		System.out.println(sb.toString());
	}

	static void backTracking(int depth, int now) {
		if(depth == M) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=now; i<=N; i++) {
			arr[depth] = i;
			backTracking(depth+1, i);
		}
	}
}
