import java.io.*;
import java.util.*;

/*
 * union-find 
 * 사이클 생기기 전까지 모든 집합을 구하고, 모든 연결관계를 count 해야함
 * 입력받은 m개와 같다면 0 
 */
public class Main {

	static int N,M, result;
	static boolean flag;
	static int [] parent, dist;
	
	public static void main(String[] args) throws IOException {
		//--------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		
		parent = new int[N];
		dist = new int[N];
		result = 0;
		flag = false;
		
		for(int i=0;i<N;i++) {
			parent[i]=i;		
		}
		
		for(int i=1;i<=M;i++) {
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			
			union(a,b);
			if(flag){
				result=i; 
				break;
			}
		}
		if(result == M && !flag) result=0;
		System.out.println(result);
	}
	
	static void union(int a, int b) {
		int pA = find(a);
		int pB = find(b);
		
		if(pA==pB) {
			flag = true;
			return;
		}
		
		parent[pB] = pA;
		dist[pA] +=1;
	}
	
	static int find(int x) {
		if(x==parent[x]) return x;
		
		return parent[x] = find(parent[x]);
	}
}
