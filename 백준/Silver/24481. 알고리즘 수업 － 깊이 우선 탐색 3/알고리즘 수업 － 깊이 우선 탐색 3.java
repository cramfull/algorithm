
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int [] visited;
	static int depth;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int vertex = Integer.parseInt(str.nextToken());
		int edge = Integer.parseInt(str.nextToken());
		int start = Integer.parseInt(str.nextToken());
		depth = 0;
		visited = new int[vertex+1];
		for(int i=0; i<vertex+1; i++) {
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
		for(int i=0;i<visited.length;i++) {
			visited[i]=-1;
		}
		dfs(start, 0);
		for(int i=1;i<visited.length;i++) {
			System.out.println(visited[i]);
		}
		
		
		
	}
	
	static void dfs(int st, int depth) {
		visited[st] = depth;
		
		for(int i=0;i<graph.get(st).size();i++) {
			int nx = graph.get(st).get(i);
			if(visited[nx]==-1) {
				dfs(nx, depth+1);
			}
		}
		
		
		
		
	}
	
	
	
}
