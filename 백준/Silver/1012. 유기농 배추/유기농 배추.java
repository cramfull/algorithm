
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int count;
	static int graph [][];
	static boolean visited [][];
	static int dx [] = new int[] {-1,1,0,0};
	static int dy [] = new int[] {0,0,-1,1};	// 상 하 좌 우 
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int TC = Integer.parseInt(br.readLine());
    	for(int i=0;i<TC;i++) {
    		StringTokenizer str = new StringTokenizer(br.readLine());
    		M = Integer.parseInt(str.nextToken());
    		N = Integer.parseInt(str.nextToken());
    		int K = Integer.parseInt(str.nextToken());
    		graph = new int[N][M];
    		visited = new boolean[N][M];
    		
    		for(int j=0;j<K;j++) {
    			str = new StringTokenizer(br.readLine());
    			int m = Integer.parseInt(str.nextToken());
    			int n = Integer.parseInt(str.nextToken());
    			graph[n][m] = 1;
    		}
    		count=0;
    		for(int j=0;j<N;j++) {
    			for(int k=0;k<M;k++) {
    				if(graph[j][k]==1 && !visited[j][k]) {
    					count++;
    					bfs(j,k);
    				}
    			}
    		}
    		sb.append(count+"\n");
    		
    	}
    	
    	System.out.println(sb.toString());
    	
    	
    	
    }
    static void bfs(int x, int y) {
    	Queue<Point> que = new LinkedList<>();
    	que.offer(new Point(x,y));
    	visited[x][y]=true;
    	
    	while(!que.isEmpty()) {
    		Point now = que.poll();
    		for(int i=0;i<4;i++) {
    			int nx = now.x+dx[i];
    			int ny = now.y+dy[i];
    			if(nx>=0 && nx<N && ny>=0 && ny<M && graph[nx][ny]==1 && !visited[nx][ny]) {
    				que.offer(new Point(nx,ny));
    				visited[nx][ny]=true;

    			}
    		}
    	}
    	
    }
    
    
    
    
    static class Point{
    	int x, y;
    	public Point(int x, int y) {
    		this.x=x;
    		this.y=y;
    	}
    }
}






