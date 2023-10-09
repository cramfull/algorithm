
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static boolean [] visited;
	static int result [] ;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N+1;i++) {
			arr.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			arr.get(st).add(ed);
			arr.get(ed).add(st);
		}
		visited = new boolean[N+1];
		result = new int[N+1];
		
		bfs(1);

		for(int i=2; i<result.length;i++) {
			sb.append(result[i]+"\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(int x) {
		Queue<Integer> que = new LinkedList<>();
		que.offer(x);
		visited[x]=true;
		while(!que.isEmpty()) {
			int k = que.poll();
			for(int i=0; i<arr.get(k).size();i++) {
				int nxt = arr.get(k).get(i);
				if(!visited[nxt]) {
					que.offer(nxt);
					visited[nxt]=true;
					result[arr.get(k).get(i)] = k;
				}
			}
		}
	}
}