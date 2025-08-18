
import java.util.*;
import java.io.*;

class Solution{
	static int N, result;
	static int [][] map;
	static boolean [][] visited;
	static int [] dx = {1,0,0,-1};
	static int [] dy = {0,1,-1,0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String line = br.readLine();
				for(int j =0; j<N;j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			
			result = 0;
			bfs(new Point(0,0,map[0][0]));
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(Point start) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		visited[start.x][start.y] = true;
		pq.offer(start);
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			if(now.x==N-1 && now.y==N-1) {
				result = map[N-1][N-1];
				return;
			}
			for(int i=0;i<4;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny]) continue;
				
				visited[nx][ny] = true;
				map[nx][ny] += map[now.x][now.y];
				pq.offer(new Point(nx, ny, map[nx][ny]));
			}
			
		}
		
	}

	static class Point implements Comparable<Point>{
		int x,y,value;
		public Point(int x,int y, int value) {
			this.x= x;
			this.y= y;
			this.value= value;
		}
		
		@Override
		public int compareTo(Point p) {
			return this.value - p.value;
		}
	}
}

