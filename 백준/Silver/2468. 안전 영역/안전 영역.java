
import java.util.*;
import java.io.*;

public class Main {
	static int maxVal;
	static int count;
	static int dx [] = {-1,1,0,0};
	static int dy [] = {0,0,-1,1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [][] graph = new int[n][n];
		boolean [][] visited = new boolean[n][n];
		int high = 0;
		for(int i=0;i<n;i++) {
			String tmp [] = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				graph[i][j]=Integer.parseInt(tmp[j]);
				high = Math.max(graph[i][j], high);
			}
		}
		maxVal = 1;
		
		for(int i=1;i<high;i++) {
			visited = new boolean[n][n];
			count = 0;
			sank(i,graph,visited);
			for(int j=0;j<n;j++) {
				for(int k=0;k<n;k++) {
					if(!visited[j][k]) {
						bfs(new Point(j,k),visited);
						count++;
					}
				}
			}
			maxVal = Math.max(maxVal, count);
		}
		System.out.println(maxVal);
		
		
		
		// 안전영역 
		// i++시 visited 배열 초기화, count 초기화 
		// 반복문, i=0(안잠기는 경우, 답은 1), i-1까지 해당 수 이하 수  visited 처리
		// 전체 bfs 탐색, visited일 경우 continue, 탐색 시 count 증가
		
		
	}
	
	static void sank(int k, int [][] graph, boolean [][] visited) {
		for(int i=0;i<graph.length;i++) {
			for(int j=0;j<graph.length;j++) {
				if(graph[i][j]<=k) {
					visited[i][j]=true;
				}
			}
		}
	}
	
	static void bfs(Point p, boolean[][]visited) {
		Queue<Point> que = new LinkedList<>();
		que.offer(p);
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx>=0&&nx<visited.length&&ny>=0&&ny<visited.length&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					que.offer(new Point(nx,ny));
				}
			}
		}
	}
	
	static class Point{
		int x,y;
		public Point(int x,int y) {
			this.x=x;
			this.y=y;
		}
	}
}
