import java.io.*;
import java.util.*;

public class Solution {

	static int N,M;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean [] visited;
	static ArrayList<ArrayList<Integer>> smallList, largeList;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC= Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N=Integer.parseInt(br.readLine());
			M=Integer.parseInt(br.readLine());
			
			graph = new ArrayList<>();
			smallList = new ArrayList<>();
			largeList = new ArrayList<>();
			
			for(int i=0;i<=N;i++) {
				graph.add(new ArrayList<>());
				smallList.add(new ArrayList<>());
				largeList.add(new ArrayList<>());
			}
			
			for(int i=0;i<M;i++) {
				StringTokenizer str = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(str.nextToken());
				int end = Integer.parseInt(str.nextToken());
				graph.get(start).add(end);
			}
			
			for(int i=1;i<=N;i++) {
				bfs(i);
			}
			
			int result = 0;
			for(int i=1;i<=N;i++) {
				if(smallList.get(i).size() + largeList.get(i).size() == N-1) result++;
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		visited = new boolean[N+1];
		que.offer(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				
				if(visited[nxt]) continue;
				
				visited[nxt] = true;
				smallList.get(nxt).add(start);
				largeList.get(start).add(nxt);
				que.offer(nxt);
			}
		}
	}
}
