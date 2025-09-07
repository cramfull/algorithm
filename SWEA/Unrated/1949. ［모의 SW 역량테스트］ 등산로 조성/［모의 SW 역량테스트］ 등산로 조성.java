import java.io.*;
import java.util.*;

/* 같은 수가 나왔을 때
 * 전 수와 2이상 차이가 나고, 남은 K가 1이상일 경우 해당 값-이전 수 만큼 K에서 뺌
 * 
 */
public class Solution {

	static int N, K, result;
	static int [][] map;
	static boolean [][] visited;
	
	static int [] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			N = Integer.parseInt(str.nextToken());
			K = Integer.parseInt(str.nextToken());
			map = new int[N][N];
			result = 0;
			int maxValue = Integer.MIN_VALUE;
	
			for(int i=0;i<N;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(line[j]);
					maxValue = Math.max(map[i][j], maxValue);
				}
			}
			List<Point> maxLists = new ArrayList<>();
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==maxValue) maxLists.add(new Point(i,j));
				}
			}	
			
			for(int i=0;i<maxLists.size();i++) {
				visited = new boolean[N][N];
				Point start = maxLists.get(i);
				visited[start.x][start.y] = true;
				dfs(start,1, 0);
				visited[start.x][start.y] = false;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void dfs(Point start, int depth, int crash) {
		if(crash>1) {
			return;
		}
		result = Math.max(depth, result);
		
		for(int i=0;i<4;i++) {
			int nx = start.x+dx[i];
			int ny = start.y+dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
			if(map[nx][ny]>=map[start.x][start.y]) {
				if(map[nx][ny]-K<map[start.x][start.y]) {
					int tmp = map[nx][ny];
					visited[nx][ny]=true;
					map[nx][ny]=map[start.x][start.y]-1;
					dfs(new Point(nx,ny),depth+1, crash+1);
					visited[nx][ny] = false;
					map[nx][ny]=tmp;
			}	
			}else if(map[nx][ny]<map[start.x][start.y]) {
				visited[nx][ny]=true;
				dfs(new Point(nx,ny),depth+1, crash);
				visited[nx][ny] = false;
			}
			
			
		}
	}
	
	static class Point{
		int x; int y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;	
		}
	}
}
