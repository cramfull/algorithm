
import java.util.*;
import java.io.*;


public class Main {
	
	static int vertex;
	static int edge;
	static ArrayList<ArrayList<Integer>> arr;
	static boolean visited [];
	static boolean isFind = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(str.nextToken());
		edge = Integer.parseInt(str.nextToken());
		
		arr = new ArrayList<>();
		visited = new boolean[vertex];
		for(int i=0;i<vertex;i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edge;i++) {
			str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			arr.get(st).add(ed);
			arr.get(ed).add(st);
		}
		for(int i=0;i<arr.size();i++) {
			visited = new boolean[vertex];
			dfs(i,1);
		}
		if(isFind) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}
	
	static void dfs(int curr, int depth) {
		if(depth==5) {
			isFind = true;
			return;
		}
		visited[curr] = true;
		for(int i=0;i<arr.get(curr).size();i++) {
			int nxt = arr.get(curr).get(i);
			if(!visited[nxt]) {
				visited[nxt]=true;
				dfs(nxt, depth+1);
				visited[nxt] = false;

				if(isFind) {
					return;
				}
			}
		}
		
		
	}
	

}
