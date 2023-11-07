
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int N,M;
	static int [] dx = new int[] {-1,1,0,0};
	static int [] dy = new int[] {0,0,-1,1};
	static int [][] graph;
	static ArrayList<Point> ripen = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		
		graph = new int [N][M];		

		for(int i=0;i<N;i++) {
			String [] tmp = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				graph[i][j]=Integer.parseInt(tmp[j]);
				if(graph[i][j]==1) {
					ripen.add(new Point(i,j));
				}
			}
		}
		bfs();
		boolean isFind = false;
		int max_value=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(graph[i][j]>max_value) {
					max_value=graph[i][j];
				}
				if(graph[i][j]==0) {
					isFind = true;
				}
			}
		}
		
		
		if(isFind) {
			System.out.println(-1);
		}else {
			System.out.println(max_value-1);

		}
		
		
	}
	
	static class Point{
		int x,y;
		
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		
	}
	
	static void bfs() {
		Queue<Point> que = new LinkedList<>();
		for(int i=0;i<ripen.size();i++) {
			que.offer(ripen.get(i));
		}
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny]==0) {
					que.offer(new Point(nx,ny));
					graph[nx][ny]=graph[now.x][now.y]+1;
				}
				
			}
			
		}
		
		
		
	}
}

