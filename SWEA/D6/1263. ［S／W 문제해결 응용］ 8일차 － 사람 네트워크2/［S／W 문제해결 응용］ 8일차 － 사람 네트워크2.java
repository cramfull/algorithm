import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int [][] board;
	static final int INF = 1001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			String [] line = br.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			board = new int[N][N];
			
			int idx=1;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(line[idx++]);
					if(board[i][j]==0 && i!=j) board[i][j]=INF; 
				}
			}
			
			for(int k=0;k<N;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						board[i][j]=Math.min(board[i][k]+board[k][j], board[i][j]);
					}
				}
			}
			

            int min = Integer.MAX_VALUE;
            for (int i=0;i<N;i++) {
                int cnt = 0;
                for (int j=0;j<N;j++) {
                    cnt += board[i][j];
                }
                min = Math.min(min, cnt);
            }
			
            sb.append("#").append(tc).append(" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
	}
}
