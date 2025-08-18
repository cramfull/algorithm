import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static ArrayList<ArrayList<Integer>> graph;
	static ArrayList<ArrayList<Integer>> smallList, largeList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		graph = new ArrayList<>();
		smallList = new ArrayList<>();
		largeList = new ArrayList<>();
		
		for(int i=0;i<=N;i++) {
			graph.add(new ArrayList<>());
			smallList.add(new ArrayList<>());
			largeList.add(new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(str.nextToken());
			int end = Integer.parseInt(str.nextToken());
			
			graph.get(start).add(end);
		}
		
		for(int i=1;i<=N;i++) {
			bfs(i);
		}
		
		int count = 0;
		for(int i=1;i<=N;i++) {
			if(smallList.get(i).size()+largeList.get(i).size() == N-1) count++;
		}
		
		System.out.println(count);
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		boolean [] visited = new boolean[N+1];
		visited[start] = true;
		que.offer(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int next = graph.get(now).get(i);
				if(visited[next]) continue;
				
				visited[next] = true;
				que.offer(next);
				largeList.get(start).add(next);
				smallList.get(next).add(start);
			}
		}
	}
}
