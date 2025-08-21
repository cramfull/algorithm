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
	static ArrayList<ArrayList<Integer>> graph;
	static int [] indegrees;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			V = Integer.parseInt(str.nextToken());
			E = Integer.parseInt(str.nextToken());
			
			graph = new ArrayList<>();
			for(int i=0;i<=V;i++) {
				graph.add(new ArrayList<>());
			}
			indegrees = new int[V+1];
			
			String [] line = br.readLine().split(" ");
			for(int i=0;i<E;i++) {
				int start = Integer.parseInt(line[i*2]);
				int end = Integer.parseInt(line[i*2+1]);
				graph.get(start).add(end);
				indegrees[end]+=1;
			}
			String result = topologySort();
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static String topologySort() {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> que = new LinkedList<>();
		for(int i=1;i<=V;i++) {
			if(indegrees[i]==0) {
				que.offer(i);
				sb.append(i).append(" ");
			}
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				indegrees[nxt]-=1;
				if(indegrees[nxt]==0) {
					que.offer(nxt);
					sb.append(nxt).append(" ");
				}
			}
		}
		
		return sb.toString();
	}
}
