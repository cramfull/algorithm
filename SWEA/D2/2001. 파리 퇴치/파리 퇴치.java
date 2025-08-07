import java.util.*;
import java.io.*;

class Solution{
 	
    static int [][] board;
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer str;
        for(int tc=1; tc<=TC; tc++) {
            str = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(str.nextToken());
            int M = Integer.parseInt(str.nextToken());
            board = new int[N][N];
//            for(int i=0;i<N;i++) {
//                board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            }
            for(int i=0;i<N;i++) {
            	String [] line = br.readLine().split(" ");
            	for(int j=0;j<N;j++) {
            		board[i][j] = Integer.parseInt(line[j]);
            	}
            }
            
            sb.append("#").append(tc).append(" ").append(calculateFlies(N, M)).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    
    static int calculateFlies(int N, int M) {
        int canKillMaximum = Integer.MIN_VALUE;
        for(int i=0;i<=N-M;i++) {
            for(int j=0;j<=N-M;j++) {
                canKillMaximum = Math.max(canKillMaximum, killFlies(i,j,M));
            }
        }
        return canKillMaximum;
    }
     
    
    static int killFlies(int x, int y, int M) {
        int sum=0;
        for(int i=x;i<x+M;i++) {
            for(int j=y;j<y+M;j++) {
                sum+=board[i][j];
            }
        }
        return sum;
    }
}