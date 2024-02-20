
import java.io.*;
import java.math.*;
import java.util.*;

//20231117 X 

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
		int [][] dp = new int [N+1][10];
		
		for(int i=0;i<10;i++) {
			dp[0][i]=1;
		}
		
		
		for(int i=1;i<=N;i++) {
			for(int j=0;j<10;j++) {
				int sum=0;
				for(int k=j;k<10;k++) {
					sum+=dp[i-1][k];
				}
				dp[i][j]=sum%10007;
			}
		}
//		for(int i=0;i<dp.length;i++) {
//			System.out.println(Arrays.toString(dp[i]));
//		}
//		
		System.out.println(dp[N][0]);
		
		
	}
}