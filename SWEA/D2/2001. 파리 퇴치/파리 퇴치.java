import java.util.*;
import java.io.*;

class Solution{
      
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=TC; tc++) {

        	String [] line = br.readLine().split(" ");
        	int N = Integer.parseInt(line[0]);
        	int M = Integer.parseInt(line[1]);
            int [][] board = new int[N][N];

            for(int i=0;i<N;i++) {
            	line = br.readLine().split(" ");
            	for(int j=0;j<N;j++) {
            		board[i][j] = Integer.parseInt(line[j]);
            	}
            }

            int canKillMaximum = Integer.MIN_VALUE;
            for(int i=0;i<=N-M;i++) {
                for(int j=0;j<=N-M;j++) {
                	int sum=0;
                    for(int k=i;k<i+M;k++) {
                        for(int l=j;l<j+M;l++) {
                            sum+=board[k][l];
                        }
                    }
                    canKillMaximum = Math.max(canKillMaximum, sum);
                }
            }
            
            sb.append("#").append(tc).append(" ").append(canKillMaximum).append("\n");
        }
        System.out.println(sb.toString());
    }
}
     