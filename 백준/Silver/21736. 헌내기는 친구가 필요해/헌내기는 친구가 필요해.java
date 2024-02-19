
import java.io.*;
import java.util.*;
import java.math.*;

// https://www.acmicpc.net/problem/2644

public class Main {
	
	static int N;
	static int M;
	static Character[][] graph;
	static boolean [][] visited;
	static int [] dx = {0,0,-1,1};
	static int [] dy = {1,-1,0,0};
	static int count;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		graph = new Character[N+1][M+1];
		visited = new boolean[N+1][M+1];

		Point st = new Point();
		for(int i=1;i<N+1;i++) {
			String str2 = br.readLine();
			for(int j=1;j<M+1;j++) {
				graph[i][j]=str2.charAt(j-1);
				if(graph[i][j]=='I') {
					st = new Point(i,j);
				}
			}
		}
		bfs(st);
		
		if(count==0) {
			System.out.println("TT");
		}else {
			System.out.println(count);
		}
		
		
		
		
	}
	
	static void bfs(Point st) {
		Queue<Point> que = new LinkedList<>();
		que.offer(st);
		visited[st.x][st.y]=true;
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx>=1 && nx<N+1 && ny>=1 && ny<M+1 && !visited[nx][ny]) {
					Point np = new Point(nx,ny);
					if(graph[np.x][np.y] == 'X') {
						
					}else if(graph[np.x][np.y] == 'P'){
						count++;
						que.offer(np);
						visited[nx][ny] = true;
					}else {
						que.offer(np);
						visited[nx][ny] = true;
					}
					}
				
				}
			}
		}
	
	
	
	
	
	static class Point{
		int x;
		int y;
		
		public Point() {
		}
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	
}
