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

	static int N;
	static double E;
	static Point [] points;
	static boolean [] visited;
	static double [] minEdge;
	static ArrayList<ArrayList<Tunnel>> tunnels;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			tunnels = new ArrayList<>();
			for(int i=0;i<N;i++) {
				tunnels.add(new ArrayList<>());
			}
			points = new Point[N];
			visited = new boolean[N];
			minEdge = new double[N];
			Arrays.fill(minEdge, Double.MAX_VALUE);
			
			String [] lineX = br.readLine().split(" ");
			String [] lineY = br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				int x = Integer.parseInt(lineX[i]);
				int y = Integer.parseInt(lineY[i]);
				points[i] = new Point(x,y);
				for(int j=i-1;j>=0;j--) {
					double distance = getDistance(points[i], points[j]);
					tunnels.get(i).add(new Tunnel(j,distance));
					tunnels.get(j).add(new Tunnel(i,distance));
				}
			}
			E = Double.parseDouble(br.readLine());
			
			long result = Math.round(prim(0)*E);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	static double getDistance(Point p1, Point p2) {
		return Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2);
	}
	
	static double prim(int start) {
		PriorityQueue<Tunnel> pq = new PriorityQueue<>((o1,o2)->(Double.compare(o1.weight, o2.weight)));
		
		double result = 0;
		int cnt = 0;
		
		minEdge[start] = 0;
		pq.offer(new Tunnel(start,0));
		
		while(!pq.isEmpty()) {
			Tunnel now = pq.poll();
			int end = now.end;
			double weight = now.weight;
			
			if(visited[end]) continue;
			
			visited[end] = true;
			result+=weight;
			cnt++;
			
			if(cnt==N) break;
			
			for(Tunnel next : tunnels.get(end)) {
				int nxtEnd = next.end;
				double nxtWeight = next.weight;
				
				if(!visited[nxtEnd] && nxtWeight < minEdge[nxtEnd]) {
					minEdge[nxtEnd] = nxtWeight;
					pq.offer(next);
				}	
			}
		}
		return result;
	}
	
	static class Tunnel{
		int end;
		double weight;
		public Tunnel(int end, double weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
