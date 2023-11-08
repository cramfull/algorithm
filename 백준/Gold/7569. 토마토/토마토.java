import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int [][][] graph;
	static int [] dx = {-1,1,0,0,0,0};
	static int [] dy = {0,0,-1,1,0,0};
	static int [] dz = {0,0,0,0,-1,1};   // 상,하,좌,우,전,후 
	static int N,M,H;
	static ArrayList<Point> arr = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		M = Integer.parseInt(str.nextToken());
		N = Integer.parseInt(str.nextToken());
		H = Integer.parseInt(str.nextToken());
		graph = new int[N][M][H];
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				String [] tmp= br.readLine().split(" ");
				for(int k=0;k<M;k++) {
					graph[j][k][i] = Integer.parseInt(tmp[k]);
					if(graph[j][k][i]==1) {
						arr.add(new Point(j,k,i));
					}
				}
			}
		}
		bfs();
		boolean isFind = false;
		int max_value = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(graph[j][k][i]==0) {
						isFind = true;
						break;
					}
					if(graph[j][k][i]>max_value) {
						max_value = graph[j][k][i];
					}
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
		int x,y,z;
		public Point(int x, int y, int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}
	
	static void bfs() {
		Queue<Point> que = new LinkedList<>();
		for(int i=0;i<arr.size();i++) {
			que.offer(arr.get(i));
		}
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<6;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nz = now.z + dz[i];
				
				if(nx>=0 && nx<N && ny>=0 && ny<M && nz>=0 && nz<H && graph[nx][ny][nz]==0) {
					que.offer(new Point(nx,ny,nz));
					graph[nx][ny][nz] = graph[now.x][now.y][now.z]+1;
				}
			}
		}
	}
}