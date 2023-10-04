
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int [] result;
	static boolean virus[];
	static int count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int vertex = Integer.parseInt(br.readLine());
		int edge = Integer.parseInt(br.readLine());
		
		for(int i=0;i<vertex+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<edge;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			graph.get(st).add(ed);
			graph.get(ed).add(st);
		}
		virus = new boolean[vertex+1];
		count = 0;
		
		bfs();
		for(int i=2;i<virus.length;i++) {
			if(virus[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	static void bfs() {
		Queue<Integer> que = new LinkedList<>();
		virus[1]=true;
		que.offer(1);
		
		while(!que.isEmpty()) {
			int k = que.poll();
			for(int i=0;i<graph.get(k).size();i++) {
				int nextVertex = graph.get(k).get(i);
				if(!virus[nextVertex]) {
					que.offer(nextVertex);
					virus[nextVertex] = true;
				}
			}
		}
		
	}
	
	
}