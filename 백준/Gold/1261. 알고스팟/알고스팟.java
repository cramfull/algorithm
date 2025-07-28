import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int [][] graph;
	static boolean [][] visited;
	static int [] dx = new int[] {0,0,-1,1};
	static int [] dy = new int[] {-1,1,0,0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		graph = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				graph[i][j] = line.charAt(j)-'0';
			}
		}
		int result = bfs(new Pair(0,0,0));
		System.out.println(result);
	}
	
	static int bfs(Pair pair) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		visited[pair.x][pair.y] = true;
		pq.offer(pair);
		while(!pq.isEmpty()) {
			Pair now = pq.poll();

			if(now.x==N-1 && now.y==M-1) {
				return now.value;
			}
			
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]) continue;
				
				visited[nx][ny]=true;
				if(graph[nx][ny]==0) {
					pq.offer(new Pair(nx,ny,now.value));
				}
				if(graph[nx][ny]==1) {
					pq.offer(new Pair(nx,ny,now.value+1));
				}
			}
		}
		return -1;
	}
	
	
	static class Pair implements Comparable<Pair>{
		int x,y,value;
		public Pair(int x, int y, int value) {
			this.x = x;
			this.y = y;
			this.value = value;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.value - o.value;
		}
	}
}
