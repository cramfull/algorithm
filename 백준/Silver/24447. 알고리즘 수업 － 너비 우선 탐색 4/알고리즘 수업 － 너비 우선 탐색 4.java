import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static int N,M, start;
	static ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
	static int count;
	static int result[];
	static int depthResult[];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(str.nextToken());
    	M = Integer.parseInt(str.nextToken());
    	start = Integer.parseInt(str.nextToken());
    	result = new int[N+1];
    	depthResult = new int[N+1];
    	for(int i=0;i<N+1;i++) {
    		graph.add(new ArrayList<Integer>());
    	}
    	for(int i=0;i<M;i++) {
    		str = new StringTokenizer(br.readLine());
    		int st = Integer.parseInt(str.nextToken());
    		int ed = Integer.parseInt(str.nextToken());
    		graph.get(st).add(ed);
    		graph.get(ed).add(st);
    	}
    	for(int i=0;i<N;i++) {
    		Collections.sort(graph.get(i));
    	}
    	count = 0;
    	for(int i=0;i<depthResult.length;i++) {
    		depthResult[i]=-1;
    	}
    	bfs(start);
    	
    	long sum=0;
    	for(int i=1;i<result.length;i++) {
    		sum+=(long)result[i]*(long)depthResult[i];
    	}
    	System.out.println(sum);
    }
    
    static void bfs(int x) {
    	count =1;
    	Queue<Integer> que = new LinkedList<>();
    	que.offer(x);
    	result[x]=count++;
    	depthResult[x]=0;
    	while(!que.isEmpty()) {
    		int now = que.poll();
    		for(int i=0;i<graph.get(now).size();i++) {
    			int nx = graph.get(now).get(i);
    			if(result[nx]==0) {
    				que.offer(nx);
    				result[nx]=count++;
    				depthResult[nx]=depthResult[now]+1;
    			}
    		}
    		
    		
    		
    		
    	}
    }
   
    
}