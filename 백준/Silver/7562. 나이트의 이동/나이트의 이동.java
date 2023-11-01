
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static Point toGo;
	static int [][] graph;
	static boolean [][] visited;
	static int count;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int dx[] = new int[] {1,2,1,2,-1,-2,-1,-2};
	static int dy[] = new int[] {-2,-1,2,1,-2,-1,2,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int i=0;i<TC;i++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			visited = new boolean[N][N];
			count = 0;
			StringTokenizer str = new StringTokenizer(br.readLine());
			Point from = new Point(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
			str = new StringTokenizer(br.readLine());
			toGo = new Point(Integer.parseInt(str.nextToken()),Integer.parseInt(str.nextToken()));
			bfs(from.x,from.y);
		}
		System.out.println(sb.toString());

	}
	static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x,y));
		visited[x][y]=true;
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<8;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny] && graph[nx][ny]==0) {
					graph[nx][ny]=graph[now.x][now.y]+1;
					visited[nx][ny]=true;
					que.offer(new Point(nx,ny));
				}
				if(nx==toGo.x && ny==toGo.y) {
					sb.append(graph[nx][ny]+"\n");
					return;
				}
			}
		}
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
