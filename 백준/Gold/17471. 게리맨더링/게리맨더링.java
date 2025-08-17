import java.io.*;
import java.util.*;

/*
 * 백트래킹으로 조합 생성
 * 
 * bfs로 조합 체크
 * 체크하면서 합을 구함
 * 
 * 앞의 선거구가 가능하다면 해당 조합의 차집합 그룹 bfs로 체크
 * 
 * 둘다 가능하다, 차이를 뺌 
 */
public class Main {
	
	static int N, sum, minResult;
	static int [] population;
	static boolean [] visited;
	static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			population[i]= Integer.parseInt(str.nextToken());
		}
		
		visited = new boolean[N+1];
		graph = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=1;i<=N;i++) {
			str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			for(int j=0;j<n;j++) {
				int node = Integer.parseInt(str.nextToken());
				graph.get(i).add(node);
				graph.get(node).add(i);
			}
		}
		
		minResult = Integer.MAX_VALUE;
		for(int i=1;i<=N/2;i++) {
			Set<Integer> set = new HashSet<>();
			backTracking(1, 0, i, set);
		}
		System.out.println((minResult==Integer.MAX_VALUE)? -1 : minResult);
	}
	
	static void backTracking(int start, int depth, int cnt, Set<Integer> set) {
		
		if(depth==cnt) {
			isGerryMandering(set);
			return;
		}
		
		for(int i=start;i<=N; i++) {
			set.add(i);
			backTracking(i+1, depth+1, cnt, set);
			set.remove(i);
		}
	}

	static void isGerryMandering(Set<Integer> set) {
		if(!isConnected(set)) return;
		int leftSum = sum;
		Set<Integer> set2 = new HashSet<>();
		for(int i=1;i<=N;i++) {
			if(!set.contains(i)) set2.add(i);
		}
		if(!isConnected(set2)) return;
		int rightSum = sum;
		
		minResult = Math.min(minResult, Math.abs(leftSum - rightSum));
	}
	
	static boolean isConnected(Set<Integer> set) {
		boolean [] visited = new boolean[N+1];
		sum = 0;
		Queue<Integer> que = new LinkedList<>();
		int start = set.iterator().next();
		int cnt = 1;
		sum+=population[start];
		visited[start] = true;
		que.offer(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				
				if(!visited[nxt] && set.contains(nxt)) {
					cnt++;
					sum+=population[nxt];
					visited[nxt] = true;
					que.offer(nxt);
				}
			}
		}
		return (cnt==set.size()) ? true : false;
	}
}
