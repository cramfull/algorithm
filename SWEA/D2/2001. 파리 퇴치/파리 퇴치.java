import java.util.*;
import java.io.*;

class Solution{
 	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int M = Integer.parseInt(str.nextToken());
			int maxSum = Integer.MIN_VALUE;
			int [][] board = new int[N][N];
			int [][]sumBoard = new int[N][N+1];

            for(int i=0;i<N;i++) {
            	String [] line = br.readLine().split(" ");
            	for(int j=0;j<N;j++) {
            		board[i][j] = Integer.parseInt(line[j]);
            	}
            }
			for(int i=0;i<N;i++) {
				for(int j=1;j<=N;j++) {
					sumBoard[i][j] = sumBoard[i][j-1]+board[i][j-1];
				}
			}
			
			for(int i=0;i<=N-M;i++) {
				for(int j=M;j<=N;j++) {
					int sum = 0;
					for(int k=i;k<i+M;k++) {
						sum+= sumBoard[k][j]-sumBoard[k][j-M];
					}
					maxSum = Math.max(maxSum, sum);
				}
			}
			sb.append(String.format("#%d %d", tc, maxSum)).append("\n");
		}
		System.out.println(sb.toString());
	}
}
