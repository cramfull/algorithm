import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main{
	static int [] dice = new int[] {1,2,3,4,5,6};
	static int graph [];
	static int visited [];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(str.nextToken());
    	int M = Integer.parseInt(str.nextToken());
    	graph = new int[101];
    	visited = new int[101];
    	
    	for(int i=0;i<N+M;i++) {
    		str = new StringTokenizer(br.readLine());
    		int st = Integer.parseInt(str.nextToken());
    		int ed = Integer.parseInt(str.nextToken());
    		graph[st] = ed; 
    	}
    	bfs(1);
    	System.out.println(visited[100]);
    	
    }
    
    static void bfs(int x) {
    	Queue<Integer> que = new LinkedList<>();
    	visited[x]=0;
    	que.offer(x);
    	while(!que.isEmpty()) {
    		int now = que.poll();
    		for(int i=0;i<6;i++) {
    			int nx = now+dice[i];
    			if(nx>=0 && nx<101) {
    				if(graph[nx]==0) {
    					if(visited[nx]!=0) {
    						continue;
    					}
    					visited[nx]=visited[now]+1;
    					que.offer(nx);
    				}else {
    					if(visited[graph[nx]]!=0) {
    						continue;
    					}
    					visited[graph[nx]]=visited[now]+1;
    					que.offer(graph[nx]);
    				}
    				    				
    				
    			}
    			if(visited[100]!=0) {
    				return;
    			}
    		}

    			
    		}
    	}
    }
    
