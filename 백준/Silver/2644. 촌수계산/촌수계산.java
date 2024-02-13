
import java.io.*;
import java.util.*;
import java.math.*;

// https://www.acmicpc.net/problem/2644

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int vertex;
	static int edge;
	static boolean [] checked;
	static int depth[];
	static boolean isFind;
	
	static int targetP;
	static int targetC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		vertex = Integer.parseInt(br.readLine());
		checked = new boolean[vertex+1];
		depth = new int[vertex+1];
		for(int i=0; i<depth.length;i++) {
			depth[i]=-1;
		}
		for(int i=0;i<vertex+1;i++) {
			graph.add(new ArrayList<Integer>());
		}
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		targetP = Integer.parseInt(str.nextToken());
		targetC = Integer.parseInt(str.nextToken());
		
		int edge = Integer.parseInt(br.readLine());
		
		for(int i=0;i<edge;i++) {
			str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			graph.get(st).add(ed);
			graph.get(ed).add(st);
		}
		bfs(targetP);
		System.out.println(depth[targetC]);
		
	}
	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(start);
		checked[start] = true;
		depth[start]=0;
		isFind = false;
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size(); i++) {
				int nx = graph.get(now).get(i);
				depth[nx]=depth[now]+1;
				if(nx == targetC) {
					return;
				}
				if(checked[nx]!=true) {
					que.offer(nx);
					checked[nx]=true;
				}
			}
		}
		
	}
}

























