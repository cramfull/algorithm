
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;



public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int vertex = Integer.parseInt(str.nextToken());
		int edge = Integer.parseInt(str.nextToken());
		int start = Integer.parseInt(str.nextToken());
		
		for(int i=0;i<vertex+1;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<edge;i++) {
			str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			graph.get(st).add(ed);
			graph.get(ed).add(st);
		}
		
		for(int i=0;i<graph.size();i++) {
			Collections.sort(graph.get(i));
		}
		
		visited = new boolean[vertex+1];
		visited[start] = true;
		sb.append(start+" ");
		dfs(start);
		visited = new boolean[vertex+1];
		sb.append("\n");
		bfs(start);
		
		System.out.println(sb.toString());
	}
	static void dfs(int start) {
		for(int i=0;i<graph.get(start).size();i++) {
			int newVertex = graph.get(start).get(i);
			if(!visited[newVertex]) {
				visited[newVertex]=true;
				sb.append(newVertex+" ");
				dfs(newVertex);
			}
		}
		
		
		
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		visited[start] = true;
		sb.append(start+" ");
		while(!que.isEmpty()) {
			int k = que.poll();
			for(int i=0;i<graph.get(k).size();i++) {
				int nextVertex = graph.get(k).get(i);
				if(!visited[nextVertex]) {
					que.offer(nextVertex);
					visited[nextVertex] = true;
					sb.append(nextVertex+" ");
				}
			}
		}
		
		
		
	}
}