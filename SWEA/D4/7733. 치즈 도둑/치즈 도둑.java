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
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{

	static int N, minDays, maxDays, result;
	static int [][] cheese, visited;
	static boolean [][] colored;
	static int [] dx = {-1,1,0,0}, dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			result = Integer.MIN_VALUE;
			cheese = new int[N][N];
			colored = new boolean[N][N];

			for(int i=0;i<N;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					cheese[i][j] = Integer.parseInt(line[j]);
					minDays = Math.min(minDays, cheese[i][j]);
					maxDays = Math.max(maxDays, cheese[i][j]);
				}
			}
			
			for(int i=minDays;i<maxDays;i++) {
				visited = new int[N][N];
				colorGreyCheese(i);
				int count = 1;
				for(int j=0;j<N;j++) {
					for(int k=0;k<N;k++) {
						if(colored[j][k] || visited[j][k]!=0) continue;
						bfs(new Point(j,k), count++);
					}
				}
				result = Math.max(count-1, result);
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}

	static void colorGreyCheese(int days) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(colored[i][j]) continue;
				if(cheese[i][j]<=days) colored[i][j]=true;
			}
		}
	}

	static void bfs(Point start, int count) {
		Queue<Point> que = new LinkedList<>();

		visited[start.x][start.y] = count;
		que.offer(start);
		
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i=0;i<4;i++) {
				int nx = now.x+dx[i];
				int ny = now.y+dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(visited[nx][ny]!=0 || colored[nx][ny]) continue;
				
				visited[nx][ny] = count;
				que.offer(new Point(nx,ny));
			}
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
