import java.util.*;
import java.io.*;

class Solution{

    static int N,M, maxSum;
    static int [][] board;
    static int [][] sumBoard;
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=TC; tc++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            N = Integer.parseInt(str.nextToken());
            M = Integer.parseInt(str.nextToken());
            maxSum = Integer.MIN_VALUE;
            board = new int[N][N];
            sumBoard = new int[N+1][N+1];
//          for(int i=0;i<N;i++) {
//              board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//          }
            for(int i=0;i<N;i++) {
                String [] line = br.readLine().split(" ");
                for(int j=0;j<N;j++) {
                    board[i][j] = Integer.parseInt(line[j]);
                }
            }
             
            saveSumBoard();
             
            for(int i=M;i<=N;i++) {
                for(int j=M;j<=N;j++) {
                    maxSum = Math.max(maxSum, calculateKillFlies(i,j));
                }
            }
            sb.append("#").append(tc).append(" ").append(maxSum).append("\n");
        }
        System.out.println(sb.toString());
    }
     
    static void saveSumBoard() {
        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                sumBoard[i][j] = sumBoard[i-1][j]+sumBoard[i][j-1]-sumBoard[i-1][j-1]+board[i-1][j-1];
            }
        }
    }
     
    static int calculateKillFlies(int x, int y) {
        return sumBoard[x][y]-sumBoard[x-M][y]-sumBoard[x][y-M]+sumBoard[x-M][y-M];
    }
}