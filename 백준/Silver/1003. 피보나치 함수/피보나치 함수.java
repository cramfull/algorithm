
import java.util.*;
import java.io.*;

public class Main {
	static int [][] dp = new int[2][41];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		dp[0][0] = 1;
		dp[1][1] = 1;
		
		
		for(int i=2;i<41;i++) {
			for(int j=0; j<2;j++) {
				dp[j][i]=dp[j][i-2]+dp[j][i-1];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[0][N]).append(" ").append(dp[1][N]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}
