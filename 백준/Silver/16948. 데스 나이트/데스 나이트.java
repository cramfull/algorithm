
import java.util.*;
import java.io.*;


public class Main {
	static int [][] graph ;
	static boolean [][] visited;
	static int [] dx = new int[] {-2,-2,0,0,2,2};
	static int [] dy = new int[] {-1,1,-2,2,-1,1};
	static int N;
	static Point st;
	static Point ed;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		st = new Point(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		ed = new Point(Integer.parseInt(str.nextToken()), Integer.parseInt(str.nextToken()));
		
		graph = new int[N][N];
		visited = new boolean[N][N];
		
		
		
		bfs();
		
		if(graph[ed.x][ed.y]==0) {
			System.out.println("-1");
		}else {
			System.out.println(graph[ed.x][ed.y]);
		}
		
		
		
		
	}
	
	public static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.offer(st);
		visited[st.x][st.y]=true;
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<6;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<N && !visited[nx][ny]) {
					graph[nx][ny]=graph[now.x][now.y]+1;
					visited[nx][ny]=true;
					que.offer(new Point(nx,ny));
				}
			}
		}
		
		
	}
	
	

}

class Point{
	int x,y;
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}