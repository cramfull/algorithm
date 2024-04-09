

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				arr[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		int [][] dp = new int[n][3];
		
		dp[0][0]=arr[0][0];
		dp[0][1]=arr[0][1];
		dp[0][2]=arr[0][2];
		for(int i=0;i<n-1;i++) {
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					int tmp = dp[i][j]+arr[i+1][k];
					if(j!=k) {
						if(dp[i+1][k]!=0) {
							dp[i+1][k]=Math.min(dp[i+1][k], tmp);
						}else {
							dp[i+1][k]=dp[i][j]+arr[i+1][k];
						}
						
					}
				}
			}
			
		}
		int result=dp[n-1][0];
		for(int j=0;j<3;j++) {
			result = Math.min(result, dp[n-1][j]);
		}
		System.out.println(result);
		
		
		
		
	}

}
