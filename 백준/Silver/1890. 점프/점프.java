
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long [][] arr = new long [N+9][N+9];
		long [][] dp = new long [N+9][N+9];
		
		for(int i=0;i<N;i++) {
			String [] tmp = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				arr[i][j]=Integer.parseInt(tmp[j]);
			}
		}
		dp[0][0]=1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				long tmp = arr[i][j];
				if(i==N-1 && j==N-1) {
					break;
				}
				if(dp[i][j]==0) {
					continue;
				}else {
					dp[i+(int)tmp][j]+=dp[i][j];
					dp[i][j+(int)tmp]+=dp[i][j];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1]);
		
		
	}
}
