import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int [] indegrees, result;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		graph = new ArrayList<>();
		indegrees = new int[N+1];
		result = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int start= Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			graph.get(start).add(end);
			indegrees[end]+=1;
		}
		
		topology_sort();
		
		for(int i=1;i<=N;i++) {
			sb.append(result[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	static void topology_sort() {
		Queue<Integer> que = new LinkedList<>();

		for(int i=1;i<=N;i++) {
			if(indegrees[i]==0) {
				que.offer(i);
				result[i]=1;
			}
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size(); i++) {
				int next= graph.get(now).get(i);
				indegrees[next]-=1;
				if(indegrees[next]==0) {
					que.offer(next);
					result[next]=result[now]+1;
				}
			}
		}
	}

}
