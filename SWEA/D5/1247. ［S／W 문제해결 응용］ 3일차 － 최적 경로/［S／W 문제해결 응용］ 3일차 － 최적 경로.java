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

	static int N, result;
	static Point [] points;
	static boolean [] visited;
	static Point [] routes;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N+2];
			routes = new Point[N];
			visited = new boolean[N+2];
			result = Integer.MAX_VALUE;
			String [] line = br.readLine().split(" ");
			for(int i=0;i<N+2;i++) {
				int x = Integer.parseInt(line[2*i]);
				int y = Integer.parseInt(line[2*i+1]);
				points[i] = new Point(x,y);
			}
			
			backTracking(0, 0, points[0]);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void backTracking(int depth, int sum, Point from) {
		if(sum>result) {
			return;
		}
		
		if(depth==N) {
			sum+=getDistance(from, points[1]);
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=2;i<points.length;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			backTracking(depth+1, sum+getDistance(from, points[i]), points[i]);
			visited[i] = false;
		}
	}
	
	static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
	}
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x =x;
			this.y=y;
		}
	}
}
