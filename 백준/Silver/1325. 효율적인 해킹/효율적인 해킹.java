import java.util.*;
import java.io.*;

/*
 * bfs
 * dist 배열에 해킹 가능 대수 저장 
 * 중첩 ArrayList는 시간초과 발생 (주석 코드)
 * -> ArrayList<Integer> [] 사용 시 통과
 *  
 *  이게 맞나.. 
 */
public class Main {
	
	static int N, M;
	static int [] dist;
	static boolean [] visited;
//	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<Integer> [] graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
//		graph = new ArrayList<>();
		graph = new ArrayList[N+1];
		
//		for(int i=0;i<=N;i++) {
//			graph.add(new ArrayList<>());
//		}
		for(int i=1;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int end = Integer.parseInt(str.nextToken());
			int start = Integer.parseInt(str.nextToken());
//			graph.get(start).add(end);
			graph[start].add(end);
		}
		
		dist = new int[N+1];
		int maxValue = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			visited = new boolean[N+1];
			dist[i] = bfs(i);
			maxValue = Math.max(dist[i], maxValue);
		}
		
		for(int i=1;i<dist.length;i++) {
			if(dist[i]==maxValue) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb.toString());
	}
	
	static int bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		int count=1;
		que.offer(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
//			for(int i=0;i<graph.get(now).size();i++) {
//				int nxt = graph.get(now).get(i);
			for(int i=0;i<graph[now].size(); i++) {
				int nxt = graph[now].get(i);
				if(visited[nxt]) continue;
				visited[nxt] = true;
				count++;
				que.offer(nxt);
			}
		}
		return count;
	}

}
