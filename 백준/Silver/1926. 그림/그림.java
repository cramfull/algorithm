

import java.io.*;
import java.util.*;
import java.math.*;

// https://www.acmicpc.net/problem/2644

public class Main {
	
	static int [] dx = new int [] {-1,1,0,0};
	static int [] dy = new int [] {0,0,-1,1};
	
	static int N;
	static int M;
	static int [][] graph;
	static boolean [][] visited;
	static int sketch;
	static int count;
	static TreeSet<Integer> set = new TreeSet<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		graph = new int [N][M];
		visited = new boolean[N][M];
		sketch = 0;
		count = 0;
		
		for(int i=0;i<N;i++) {
			str = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				graph[i][j]=Integer.parseInt(str.nextToken());
			}
		}
		

		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]==1 && visited[i][j]!=true) {
					bfs(i,j);
				}
			}
		}
		System.out.println(sketch);
		if(sketch == 0) {
			System.out.println(0);
		}else {
			System.out.println(set.last());
		}

		
		
	}
	
	
	static void bfs(int x, int y) {
		Queue<Point> que = new LinkedList<>();
		que.offer(new Point(x,y));
		visited[x][y] = true;
		sketch++;
		count = 1;
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny]==1 && visited[nx][ny]!=true) {
					que.offer(new Point(nx,ny));
					visited[nx][ny]=true;
					count++;
				}
			}
		}
		set.add(count);
		
	}
	
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}


	
}













