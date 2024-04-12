
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long [] dp = new long[n+4];
		
		dp[0]=0;
		dp[1]=3;
		dp[2]=7;
		dp[3]=17;
		
		
		if(n>3) {
			for(int k=4; k<=n; k++) {
				dp[k]=(2*dp[k-1]+dp[k-2])%9901;
			}
		}
		System.out.println(dp[n]);
		
	}

}
