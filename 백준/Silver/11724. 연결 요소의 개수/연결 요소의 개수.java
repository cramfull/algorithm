
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean [] visited;
	static int connected;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	
    	int vertex = Integer.parseInt(str.nextToken());
    	int edge = Integer.parseInt(str.nextToken());
    	
    	for(int i=0;i<vertex+1; i++) {
    		graph.add(new ArrayList<>());
    	}
    	
    	for(int i=0;i<edge;i++) {
    		str = new StringTokenizer(br.readLine());
    		int st = Integer.parseInt(str.nextToken());
    		int ed = Integer.parseInt(str.nextToken());
    		
    		graph.get(st).add(ed);
    		graph.get(ed).add(st);
    	}
    	visited = new boolean[vertex+1];
    	connected = 0;
    	bfs(1);
    	for(int i=2;i<graph.size();i++) {
    		if(visited[i]) {
    			connected++;
    			continue;
    		}
    		bfs(i);
    	}
    	System.out.println(vertex - connected);
    	
    	
    	
    }
    static void bfs(int start) {
    	Queue<Integer> que = new LinkedList<>();
    	que.offer(start);
    	visited[start] = true;
    	
    	while(!que.isEmpty()) {
    		int k = que.poll();
    		for(int i=0; i<graph.get(k).size();i++) {
    			int nxt = graph.get(k).get(i);
    			
    			if(!visited[nxt]) {
    				visited[nxt] = true;
    				que.offer(nxt);
    				
    			}
    		}
    		
    		
    	}
    	
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
}