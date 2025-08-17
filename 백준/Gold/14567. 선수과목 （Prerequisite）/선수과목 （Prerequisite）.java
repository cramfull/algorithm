import java.io.*;
import java.util.*;

/*
 * 선수과목
 * 
 * 위상정렬 사용
 * indegree(진입차수) 배열에 해당 정점으로 진입하는 간선의 개수를 카운트
 * que에서 offer하는 시 = 카운트 1
 * poll과 동시에 해당 카운트를 배열에 저장 
 * 
 */
public class Main {

	static int N, M;
	static int [] indegree, result;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		graph = new ArrayList<>();
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		indegree = new int[N+1];
		result = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			graph.get(start).add(end);
			indegree[end]+=1;
		}
		topologySort();
		
		for(int i=1;i<=N;i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	static void topologySort() {
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(indegree[i]==0) {
				que.offer(i);
				result[i]=1;
			}
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				indegree[nxt]-=1;
				if(indegree[nxt]==0) {
					result[nxt] = result[now]+1;
					que.offer(nxt);
				}
			}
		}
	}

}
