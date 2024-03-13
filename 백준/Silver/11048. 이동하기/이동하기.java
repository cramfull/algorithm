
import java.util.*;
import java.io.*;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N,M;
		StringTokenizer str = new StringTokenizer(br.readLine());
		N=Integer.parseInt(str.nextToken());
		M=Integer.parseInt(str.nextToken());
		int [][] arr = new int[N+1][M+1];
		int [][] dp = new int[N+1][M+1];
		
		for(int i=1;i<N+1;i++) {
			String [] tmp = br.readLine().split(" ");
			for(int j=1; j<M+1; j++) {
				arr[i][j]=Integer.parseInt(tmp[j-1]);
			}
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1; j<=M; j++) {
				dp[i][j]=arr[i][j]+(int)Math.max(Math.max(dp[i-1][j],dp[i][j-1]),Math.max(dp[i][j-1], dp[i-1][j-1]));
			}
		}
		System.out.println(dp[N][M]);
		
		
		
		
		
	}
}
