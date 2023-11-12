import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static int N,K;
	static int [] graph = new int[100001];
	static int [] dx = new int[] {-1,1};
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer str = new StringTokenizer(br.readLine());
       
       N = Integer.parseInt(str.nextToken());
       K = Integer.parseInt(str.nextToken());
       if(N==K) {
    	   System.out.println("0");
       }else {
    	   bfs(N);
           System.out.println(graph[K]);
       }
       
       
       
    }
   
    static void bfs(int x) {
    	Queue<Integer> que = new LinkedList<>();
    	que.offer(x);
    	graph[x] = 0;
    	while(!que.isEmpty()) {
    		int now = que.poll();
    		for(int i=0;i<3; i++) {
    			int nx = now;
    			if(i<2) {
    				nx+=dx[i];
    			}else if(i==2 && nx<=50000){
    				nx*=2;
    			}
    			if(nx>=0 && nx<graph.length && graph[nx]==0) {
    				graph[nx] = graph[now]+1;
    				que.offer(nx);
    			}
    			if(graph[K]!=0) {
    				return;
    			}
    		}
    	}
    	
    }
    
    
    
}