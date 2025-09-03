import java.io.*;
import java.util.*;

public class Solution {

	static int N,L;
	static int [][] dp;
	static int [] kcals;
	static int [] scores;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			L = Integer.parseInt(str.nextToken());
			
			scores = new int[L+1];
			kcals = new int[N+1];
			
			for(int i=1;i<=N;i++) {
				str = new StringTokenizer(br.readLine());
				scores[i] = Integer.parseInt(str.nextToken());
				kcals[i] = Integer.parseInt(str.nextToken());
			}
			
			dp = new int[N+1][L+1];
			solving();
			
			sb.append("#").append(tc).append(" ").append(dp[N][L]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void solving() {
		for(int i=1;i<=N;i++) {
			int kcal = kcals[i];
			int score = scores[i];
			for(int j=1;j<=L;j++) {
				if(kcal<=j) {
					dp[i][j]=Math.max(dp[i-1][j] ,dp[i-1][j-kcal]+score);
				}else {
					dp[i][j]=dp[i-1][j];
				}
			}
		}
	}
}
