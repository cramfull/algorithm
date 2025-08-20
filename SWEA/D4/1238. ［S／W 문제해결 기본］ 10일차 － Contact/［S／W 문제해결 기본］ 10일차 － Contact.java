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
{static int N, start;
	static ArrayList<ArrayList<Integer>> graph;
	static int [] dist;
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(str.nextToken());
			start = Integer.parseInt(str.nextToken());
			
			graph = new ArrayList<>();
			for(int i=0;i<=100;i++) {
				graph.add(new ArrayList<>());
			}
			dist = new int[101];
			visited = new boolean[101];
			
			String [] line = br.readLine().split(" ");
			for(int i=0;i<N/2;i++) {
				int start = Integer.parseInt(line[2*i]);
				int end = Integer.parseInt(line[2*i+1]);
				if(!graph.get(start).contains(end)) {
					graph.get(start).add(end);
				}
			}
			
			int maxCount = Integer.MIN_VALUE;
			int maxIdx = 100;
			bfs(start);
			for(int i=0;i<101;i++) {
				if(dist[i]>=maxCount) {
					maxCount = dist[i];
					maxIdx = i;
				}
			}
			sb.append("#").append(tc).append(" ").append(maxIdx).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();
		dist[start] = 1;
		visited[start] = true;
		que.offer(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i=0;i<graph.get(now).size();i++) {
				int nxt = graph.get(now).get(i);
				if(visited[nxt])continue;
				
				dist[nxt]=dist[now]+1;
				visited[nxt] = true;
				que.offer(nxt);
			}
		}
	}
}
