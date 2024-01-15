
import java.io.*;
import java.util.*;

public class Main {
	static int [][] dp;
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());		
		int n = Integer.parseInt(str.nextToken());
		int k = Integer.parseInt(str.nextToken())-1;
		
		dp = new int[n][n];
		for(int i=0;i<n;i++) {
			dp[0][i] = 1; 
		}
		for(int i=0;i<n;i++) {
			dp[i][0] = 1; 
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1; j<n;j++) {
				dp[i][j]=dp[i][j-1]+dp[i-1][j];
			}
		}
		
		
		System.out.println(dp[n-k-1][k]);
		
		
		
//		
//		StringBuilder sb = new StringBuilder();
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<n;j++) {
//				sb.append(dp[i][j]+" ");
//			}
//			sb.append("\n");
//		
//		}
//		
//		System.out.println(sb.toString());
	}
	
	
	
	
	
	
}
