
import java.util.*;
import java.io.*;

class Solution{
	static int N;
	static int [][] map;
	static boolean [][] visited;
	static int [][] d = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
	
	public static void main(String args[]) throws Exception{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int TC = Integer.parseInt(br.readLine());
		 
		 for(int tc=1;tc<=TC;tc++) {
			 N = Integer.parseInt(br.readLine());
			 map = new int[N][N];
			 visited = new boolean[N][N];
			 
			 for(int i=0;i<N;i++) {
				 String line = br.readLine();
				 for(int j=0;j<N;j++) {
					 map[i][j] = line.charAt(j) - '0';
				 }
			 }
			 StringBuilder sb = new StringBuilder();
			 int result = bfs(new Point(0,0,0));
			 sb.append("#").append(tc).append(" ").append(result);
			 
			 System.out.println(sb.toString());
		 }
	}
	
	
	static int bfs(Point start) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		pq.offer(start);
		visited[start.x][start.y]=true;	
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			
			if(now.x == N-1 && now.y == N-1) {
				return now.value;
			}
			
			for(int i=0;i<4;i++) {
				int nx = now.x + d[i][0];
				int ny = now.y + d[i][1];
				
				if(nx >-1 && ny >-1 && nx<N && ny<N && !visited[nx][ny]) {
					visited[nx][ny] = true;
					pq.add(new Point(nx,ny,now.value + map[nx][ny]));
				}
			}
		}
		
		
		return -1;
	}
	
	static class Point implements Comparable<Point>{
		int x;
		int y;
		int value;
		public Point(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public int compareTo(Point o) {
			return this.value - o.value;
		}
	}	
}