import java.io.*;
import java.util.*;

/* 0813 15:!2
 * dfs
 * 열이 M에 도달하면 vsited 처리, 종료
 */
public class Main {
	
	static int R, C, result;
	static boolean flag;
	static String [][] board;
	static boolean [][] visited;
	
	static int [] dx = {-1,0,1};
	static int [] dy = {1,1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(str.nextToken());
		C = Integer.parseInt(str.nextToken());
		board = new String[R][C];
		visited = new boolean[R][C];
		result = 0;
		flag = false;
		
		for(int i=0;i<R;i++) {
			board[i] = br.readLine().split("");
		}
		
		for(int i=0;i<R;i++) {
			flag = false;
			dfs(new Point(i,0));
//			if(!flag) break;
		}
		
		System.out.println(result);
	}

	static void dfs(Point point) {
		if(flag) return;		
		if(point.y==C-1) {
			flag = true;
			result++;
			return;
		}
		
		visited[point.x][point.y] = true;
		
		for(int i=0;i<3;i++) {
			int nx = point.x + dx[i];
			int ny = point.y + dy[i];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C || visited[nx][ny]) continue;
			
			if(board[nx][ny].equals("x")) continue;
			
			visited[nx][ny] = true;
			dfs(new Point(nx,ny));	
			
			if(flag) return;
		}
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
