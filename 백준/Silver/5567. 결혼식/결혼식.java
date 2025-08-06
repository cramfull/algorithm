import java.io.*;
import java.util.*;

/*
 * 그래프 순회
 * count = count+1, dist에 저장
 * dist[i]<=2 인 경우 
 */
public class Main {

	static int N, M, totalCount;
	static int [] dist;
	static boolean [] visited;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		totalCount = 0;
		graph = new ArrayList<ArrayList<Integer>>();
		dist = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}

		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		bfs();
		
		System.out.println(totalCount);
	
	}
	
	static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		dist[1] = 0;
		visited[1] = true;
		que.offer(1);
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				if(visited[nxt]) continue;
				
				visited[nxt] = true;
				dist[nxt] = dist[now]+1;
				if(dist[nxt]<=2) totalCount++;
				que.offer(nxt);
			}
		}
	}
}
