
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long [] dp = new long[1000001];
		dp[0]=0%1000000009;
		dp[1]=1%1000000009;
		dp[2]=2%1000000009;
		dp[3]=4%1000000009;
		
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(br.readLine());
			if(dp[k]==0) {
				for(int j=4;j<=k;j++) {
					dp[j]=(dp[j-1]+dp[j-2]+dp[j-3])%1000000009;
				}
			}
			System.out.println(dp[k]);
		}
		
		
		
	}

}
