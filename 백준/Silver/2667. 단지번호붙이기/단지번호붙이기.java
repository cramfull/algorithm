import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static int N;
	static int graph [][];
	static boolean visited[][];
	static int count;
	static int result;
	static int [] dx = new int[] { -1,1,0,0 };
	static int [] dy = new int[] { 0,0,-1,1 };		// 상 하 좌 우
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	N = Integer.parseInt(br.readLine());
    	graph = new int[N][N];
    	visited = new boolean[N][N];
    	for(int i=0;i<N;i++) {
    		String [] tmp = br.readLine().split("");
    		for(int j=0;j<N;j++) {
    			graph[i][j]=Integer.parseInt(tmp[j]);
    		}
    	}
    	result =0;
    	ArrayList<Integer> arr = new ArrayList<>();
    	for(int i=0;i<N;i++) {
    		for(int j=0;j<N;j++) {
    	    	count =0;
    			if(graph[i][j]==1 && !visited[i][j]) {
                    visited[i][j]=true;
    				dfs(i,j);
    				arr.add(count);
    				result++;
    			}
    		}
    	}
    	Collections.sort(arr);
    	System.out.println(result);
    	for(int a : arr) {
    		System.out.println(a);
    	}

    	
    }
    static void dfs(int x, int y) {
    	Point now = new Point(x,y);
    	count++;
    	for(int i=0;i<4;i++) {
    		int nx = now.x + dx[i];
    		int ny = now.y + dy[i];
    		if(nx>=0 && nx<N && ny>=0 && ny<N && graph[nx][ny]==1 && !visited[nx][ny]) {
                visited[nx][ny]=true;
    			dfs(nx,ny);
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


