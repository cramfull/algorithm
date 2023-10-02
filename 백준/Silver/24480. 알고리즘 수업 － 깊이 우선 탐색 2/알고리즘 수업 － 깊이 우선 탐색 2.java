import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int [] arr;
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int vertex = Integer.parseInt(str.nextToken());
		int edge = Integer.parseInt(str.nextToken());
		int start = Integer.parseInt(str.nextToken());
		
		graph = new ArrayList<>();
		arr = new int[vertex+1];
		
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
		count=1;
		dfs(start);
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<arr.length; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	static void dfs(int vertex) {
		arr[vertex] = count;
		for(int i=0;i<graph.get(vertex).size();i++) {
			int newVertex = graph.get(vertex).get(i);
			
			if(arr[newVertex]==0) {
				count++;
				dfs(newVertex);
			}
			
		}
	}
	
	
	
	
	
	
	
}