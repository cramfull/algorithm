
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int [][] graph;
	static boolean [][] visited;
	static int [] dx = new int[] {-1,1,0,0};
	static int [] dy = new int[] {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		graph = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String [] tmp = br.readLine().split("");
			for(int j=0;j<M;j++) {
				graph[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		bfs(0,0);
		System.out.println(graph[N-1][M-1]);
	}
	static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x,y));
		graph[x][y]=1;
		visited[x][y]=true;
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && graph[nx][ny]==1) {
					que.offer(new Point(nx,ny));
					visited[nx][ny]=true;
					graph[nx][ny]=graph[now.x][now.y]+1;
				}
				if(graph[N-1][M-1]!=1) {
					return;
				}
			}
		}
		
		
	}
	
	
	
	static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}