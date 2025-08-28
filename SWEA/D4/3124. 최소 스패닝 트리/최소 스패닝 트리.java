/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{		
	static int V, E;
	static int [] minEdge;
	static boolean [] visited;
	static ArrayList<ArrayList<Edge>> graph;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(str.nextToken());
			E = Integer.parseInt(str.nextToken());
			
			minEdge = new int[V+1];
			Arrays.fill(minEdge, Integer.MAX_VALUE);
			visited = new boolean[V+1];
			graph = new ArrayList<>();
			
			
			for(int i=0;i<V+1;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<E;i++) {
				str = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(str.nextToken());
				int end = Integer.parseInt(str.nextToken());
				int weight = Integer.parseInt(str.nextToken());
				
				graph.get(start).add(new Edge(end, weight));
				graph.get(end).add(new Edge(start, weight));
			}
			
			long result = prim(1);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static long prim(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((o1,o2)->(o1.weight-o2.weight));
		
		long result = 0;
		int cnt = 0;
		
		minEdge[start] = 0;
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int end = now.end;
			int weight = now.weight;
			
			if(visited[end]) continue;
			
			visited[end] = true;
			result+=weight;
			cnt++;
			
			if(cnt==V) break;
			
			for(Edge next : graph.get(end)) {
				int nxtEnd = next.end;
				int nxtWeight = next.weight;
				
				if(!visited[nxtEnd] && nxtWeight < minEdge[nxtEnd]) {
					minEdge[nxtEnd] = nxtWeight;
					pq.offer(next);
				}
			}
		}
		
		return result;
	}
	
	static class Edge{
		int end, weight;
		
		public Edge(int end, int weight) {
			this.end =end;
			this.weight =weight;
		}
	}

}
