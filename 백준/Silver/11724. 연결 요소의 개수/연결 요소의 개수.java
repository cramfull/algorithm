import java.io.*;
import java.util.*;


public class Main {
	
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean [] visited;
	static int [] group;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		graph = new ArrayList<>();
		visited = new boolean[N+1];
		group = new int[N+1];

		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		/*
		 *  연결 요소가 없는 경우의 각 노드는 독립된 네트워크이다.
		 * testcase
		 * input 
		 * 5 0
		 * answer 
		 * 5 
		 * */
		int result = Integer.MIN_VALUE;

		if(M==0) {
			result = N;
		}else {
			int cnt = 1;
			for(int i=1;i<=N;i++) {
				if(visited[i]) continue;
				
				bfs(i, cnt);
				cnt++;
				result = Math.max(result, group[i]);
			}
		}
		System.out.println(result);	
	}
	
	static void bfs(int start, int cnt) {
		Queue<Integer> que = new LinkedList<>();
		visited[start] = true;
		group[start] = cnt;
		que.offer(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				if(visited[nxt]) continue;
				
				visited[nxt] = true;
				group[nxt] = cnt;
				que.offer(nxt);
			}
		}
	}
}
