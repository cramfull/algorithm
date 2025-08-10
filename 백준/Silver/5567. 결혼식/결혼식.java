import java.io.*;
import java.util.*;

public class Main {
	static int N,M, totalCount;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean [] visited;
	static int [] dist;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		graph = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		dist = new int[N+1];
		
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		bfs(1);
//		int cnt = 0;
//		for(int i=1;i<dist.length-1;i++) {
//			if(dist[i]>0 && dist[i]<=2) {
//				cnt++;
//			}
//		}
		System.out.println(totalCount);
		
	}
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		visited[start] = true;
		dist[start] = 0;
		que.offer(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				if(visited[nxt]) continue;
				visited[nxt] = true;
				dist[nxt] = dist[now]+1;
				if(dist[nxt]<=2) {
					totalCount++;
					que.offer(nxt);
				}
			}
		}
	}

}
