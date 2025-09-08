import java.io.*;
import java.util.*;

/* 0909 00:02
 * 냅색
 * dp는 메모리를 더 쓰고 시간을 줄이는 방법
 * 무게에 맞게 가방에 넣을 수 있는 물건 중 최대 가치를 가지는 것
 * 물건을 가질 때, 안가질 때, 두가지를 생각할 수 있다.
 */
public class Solution {
	
	static int N,K;
	static int [] weight, value;
	static int [][] dp;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			
			weight = new int[N+1];
			value = new int[N+1];
			
			dp = new int[N+1][K+1];
			
			for(int i=1;i<=N;i++) {
				str = new StringTokenizer(br.readLine());
				weight[i]=Integer.parseInt(str.nextToken());
				value[i]=Integer.parseInt(str.nextToken());
			}
			
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=K;j++) {
					if(weight[i]<=j) {
						dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
					}else {
						dp[i][j]= dp[i-1][j];
					}
				}
			}
			 
			
			sb.append("#").append(tc).append(" ").append(dp[N][K]).append("\n");
		}
		System.out.println(sb.toString());
	}
}
