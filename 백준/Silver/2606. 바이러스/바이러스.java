import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;


// dfs로 다시풀어보기 

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int count;
	static boolean [] virus;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int vertex = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		StringTokenizer str ;
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
		count = 0;
		virus = new boolean[vertex+1];
		dfs(1);
		for(int i=2;i<virus.length;i++) {
			if(virus[i]) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	static void dfs(int start) {
		virus[start] = true;
		for(int i=0;i<graph.get(start).size();i++) {
			int newVertex = graph.get(start).get(i);
			if(!virus[newVertex]) {
				dfs(newVertex);
			}
		}
	}
	
	
	

	
	
}