import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static int N,M;
	static int [][] graph;
	static boolean [][] visited;
	static int [] dx = new int[] {-1,-1,-1,0,1,1,1,0};
	static int [] dy = new int[] {-1,0,1,1,1,0,-1,-1};
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str;
    	StringBuilder sb = new StringBuilder();
    	while(true) {
    		str = new StringTokenizer(br.readLine());
    		 M = Integer.parseInt(str.nextToken());
    		 N = Integer.parseInt(str.nextToken());
    		if(N==0 && M==0) {
    			break;
    		}
    		graph =  new int [51][51];
    		visited = new boolean [51][51];
    		for(int i=0;i<N;i++) {
    			str = new StringTokenizer(br.readLine());
    			for(int j=0;j<M;j++) {
    				graph[i][j] = Integer.parseInt(str.nextToken());
    			}
    		}
    		
    		int result = 0;
    		for(int i=0;i<N;i++) {
        		for(int j=0;j<M;j++) {
        			if(graph[i][j]==1&& !visited[i][j]) {
        				bfs(i,j);
        				result++;
        			}
        		}
        	}
    		sb.append(result+"\n");
    		
    	}
    	System.out.println(sb.toString());
    }
    static void bfs(int x,int y) {
    	Queue<Point> que = new LinkedList<>();
    	que.offer(new Point(x,y));
    	visited[x][y] = true;
    	while(!que.isEmpty()) {
    		Point now = que.poll();
    		for(int i=0;i<8;i++) {
    			int nx = now.x+dx[i];
    			int ny = now.y+dy[i];
    			
    			if(nx>=0 && nx<N && ny>=0 && ny<M && !visited[nx][ny] && graph[nx][ny]==1) {
    				visited[nx][ny]=true;
    				que.offer(new Point(nx,ny));
    			}
    		}
    	}
    }
    
    
    static class Point{
    	int x,y;
    	public Point(int x, int y) {
    		this.x=x;
    		this.y=y;
    				
    	}
    }
}