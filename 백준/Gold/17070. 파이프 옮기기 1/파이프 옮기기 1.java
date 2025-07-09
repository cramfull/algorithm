
import java.util.*;
import java.io.*;

public class Main {
	static int [] dx = new int[] {0,1,1};	// 가로, 세로, 대각
	static int [] dy = new int[] {1,0,1};
	static int result;
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int [][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		result = 0;
		dfs(arr, N, 0,1,0);
		System.out.println(result);
	}
	
	static void dfs(int [][] arr, int N, int x, int y, int idx) {
		if(x==N-1 && y==N-1) {
			result++;
			return;
		}
        
		for(int i=0;i<3;i++) {		
			if(check(arr, N, idx, i, x, y)) {
				continue;
			}
			
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && arr[nx][ny]==0) {
				dfs(arr, N, nx, ny, i);
			}
		}
	}

	static boolean check(int [][] arr, int N, int idx, int i, int x, int y) {
		if(idx==0 && i==1) {
			return true;
		}
		if(idx==1 && i==0) {
			return true;
		}
		if(i==2) {
			for(int j=0;j<3;j++) {
				int tmpX = x+dx[j];
				int tmpY = y+dy[j];
				if(tmpX>=0 && tmpY>=0 && tmpX<N && tmpY<N) {
					if(arr[tmpX][tmpY]!=0) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
