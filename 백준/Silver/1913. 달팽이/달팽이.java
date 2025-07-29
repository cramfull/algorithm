import java.io.*;
import java.util.*;

public class Main {

	static int [] dx = new int[] {-1,0,1,0}; // 상, 우, 하, 좌
	static int [] dy = new int[] {0,1,0,-1};
	static long [][] arr;
	static int [] result;
	static int N, target;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		target = Integer.parseInt(br.readLine());
		
		arr = new long[1000][1000];
		// N/2+1, N/2+1
		
		// 상 1 우 1 하 2 좌 2 상 3 우 3 하 4 좌 4
		// 1   2    33   44  111  222   3333   4444
		// 1 2 3 3 4 4 1 1 1 2 2 2 3 3 3 3 4 4 4 4 
		
		result = new int [] {N/2+1,N/2+1};
		solve();
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		sb.append(result[0]).append(" ").append(result[1]);
		System.out.println(sb.toString());
		
	}

	static void solve() {
		long num = 1;
		int x = N/2+1;
		int y = N/2+1;
		
		arr[x][y] = num;
		int delta = 0;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<2;j++) {
				for(int k=1; k<=i;k++) {
					x += dx[delta];
					y += dy[delta];
					arr[x][y]=++num;
					if(num==target) {result[0]=x; result[1]=y;}
					if(x==1 && y ==1) return;
				}
				delta = (delta+1)%4;
			}
		}
	}
}
