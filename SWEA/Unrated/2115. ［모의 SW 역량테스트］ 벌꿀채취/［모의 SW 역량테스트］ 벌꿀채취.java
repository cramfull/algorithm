import java.io.*;
import java.util.*;

/* 13:30
 * 연속된 M개 이하의 수의 합이 C이하인 가장 큰 경우 * 2
 * 
 * 가중합
 * 입력 받으며 가중합 테이블 만들고, M개일때 부터 1개까지 C값에 근접한 거로
 * 
 * 백트래킹 
 * i,j   /  M 사이즈의 칸 선택해서 부분집합의 합이 C보다 작은 것 중 
 * 제일 큰 것 선택해서 제곱의 합 계산해서 같이 넘김
 * 
 * i, j+1 으로  보내고
 * 	j+M<N 일 때, i==N-1이면 리턴, 아니면 i+1,j=0으로 보내고
 * 	
 * 
 * 다른 M사이즈의 칸 찾기
 * 
 */
public class Solution {

	static int [][] board;
	static int [][] prefix;
	static int N,M,C,maxAmount,maxProfit,total;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			M = Integer.parseInt(str.nextToken());
			C = Integer.parseInt(str.nextToken());
			
			board = new int[N][N];
			prefix = new int[N][N+1];
			total = 0;
			for(int i=0;i<N;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					board[i][j] = Integer.parseInt(line[j]);
					prefix[i][j+1] = prefix[i][j] + board[i][j];
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<=N-M;j++) {
					maxProfit=0;
					maxAmount=0;
					chooseHoneys(i,j,0,0,0);
					int result1 = maxProfit;
					for(int k=i;k<N;k++) {
						for(int l=0;l<=N-M;l++) {
//							if(i==k && (l+M-1>=j && j+M-1>=l)) continue;
							if(i==k) continue;
							maxProfit=0;
							maxAmount=0;
							chooseHoneys(k,l,0,0,0);
							int result2 = maxProfit;
							total = Math.max(result1+result2, total);
						}
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(total).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void chooseHoneys(int x, int y, int depth, int value, int profitSum) {
		if(value>C) return;
		
		if(depth == M) {
			if(maxAmount<=value) {
				maxAmount = value;
				maxProfit=Math.max(maxProfit,profitSum);

			}
			return;
		}
		
		chooseHoneys(x, y+1, depth+1, value+board[x][y], profitSum+(int)Math.pow(board[x][y],2));
		
		chooseHoneys(x, y+1, depth+1, value, profitSum);
	}
}
