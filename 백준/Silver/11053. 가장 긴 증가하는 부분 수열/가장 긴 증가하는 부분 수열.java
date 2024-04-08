
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int nums [] = new int[N+1];
		StringTokenizer str =new StringTokenizer(br.readLine());
		nums[0]=0;
		for(int i=1;i<N+1;i++) {
			nums[i]=Integer.parseInt(str.nextToken());
		}
		
		
		
		int dp [] = new int[N+1];
		dp[0]=0;
		for(int i=1;i<N+1;i++) {
			int mx = 0;
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j]) {
					mx = Math.max(mx, dp[j]);
				}
			}
			dp[i]=mx+1;
		}
		int result=0;
		for(int i=0;i<N+1;i++) {
			result = Math.max(result, dp[i]);
			
		}
		
		System.out.println(result);
		
		
		// dp[i]는 dp[0] ~ dp[i-1] 중 최대값 +1
		// nums[i]>nums[j]인 값 중 최대값 
		// -> dp[i] = max(dp[0]~dp[i-1]) + 1
		
		
		
		
		
	}

}
