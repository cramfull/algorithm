
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int count;
	static int graph [][];
	static boolean visited [][];
	static int dx [] = new int[] {-1,1,0,0};
	static int dy [] = new int[] {0,0,-1,1};	// 상 하 좌 우 
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	graph = new int[N][N];
    	
    	for(int i=0;i<N;i++) {
    		String [] tmp = br.readLine().split("");
    		for(int j=0;j<N;j++) {
    			graph[i][j] = Integer.parseInt(tmp[j]);
    		}
    	}
    	visited = new boolean[N][N];
    	ArrayList<Integer> arr = new ArrayList<>();
    	int result = 0;
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    			if(graph[i][j]==1&& !visited[i][j]) {
    				bfs(i,j);
    				arr.add(count);
    				result++;
    			}
    		}
    	}
    	Collections.sort(arr);
    	
    	System.out.println(result);
    	for(int i=0;i<arr.size();i++) {
    		System.out.println(arr.get(i));
    	}
    	
    	
    	
    	
    	
    }
    
    static void bfs(int x, int y) {
    	Queue<Point> que = new LinkedList<>();
    	que.offer(new Point(x,y));
    	graph[x][y]=0;
		count = 0;

    	while(!que.isEmpty()) {
    		count++;
    		Point now = que.poll();
    		for(int i=0;i<4;i++) {
    			int nx = now.x + dx[i];
    			int ny = now.y + dy[i];
    			if(nx>=0 && nx<N && ny>=0 && ny<N && graph[nx][ny]==1&&!visited[nx][ny]) {
    				graph[nx][ny]=0;
    				que.offer(new Point(nx,ny));
    			}
    		}
    	}
    	
    	
    }
    
    
    static class Point{
    	int x, y;
    	
    	public Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    	
    }
    
}