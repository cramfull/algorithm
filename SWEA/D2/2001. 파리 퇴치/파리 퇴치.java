import java.util.*;
import java.io.*;

class Solution{
      
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer str;
        for(int tc=1; tc<=TC; tc++) {
            str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            int [][] board = new int[N][N];
            for(int i=0;i<N;i++) {
                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
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