
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int [] result;
	static int count;
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
			Collections.sort(graph.get(i), Comparator.reverseOrder());
		}
		
		count = 1;
		result = new int[vertex+1];
		
		bfs(start);
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<result.length;i++) {
			sb.append(result[i]).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(start);
		result[start] = count++;
		
		while(!que.isEmpty()) {
			int k = que.poll();
			for(int i=0;i<graph.get(k).size();i++) {
				int nextVertex = graph.get(k).get(i);
				
				if(result[nextVertex]==0) {
					que.offer(nextVertex);
					result[nextVertex]=count++;
				}
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
}