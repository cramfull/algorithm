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

	static int N, result, maxCount;
	static ArrayList<Point> points;
	static boolean [][] visited;
	static int [] dx = {-1, 0, 1, 0}, dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			points = new ArrayList<>();
			visited = new boolean[N][N];
			result = Integer.MAX_VALUE;
			maxCount = 0;
			for(int i=0;i<N;i++) {
				String [] line = br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					if(Integer.parseInt(line[j])==1) {
						visited[i][j]=true;
						if(!(i==0 || i==N-1 ||j==0 || j==N-1)) 	points.add(new Point(i,j));
					}
				}
			}
				checkProccess(0,0,0);
			
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static void checkProccess(int depth, int sum, int cnt) {
//		if(sum>result) {
//			return;
//		}
//		
		if(depth==points.size()) {
			if(cnt>maxCount) {
				result = sum;
				maxCount = cnt;
			} 
			if(cnt==maxCount) result = Math.min(result, sum);
			
			return;
		}
		
		Point now = points.get(depth);			
		for(int i=0;i<4;i++) {
			if(checkIsInLine(now, dx[i], dy[i])) continue;
	
			int lineSum = toggleVisited(now,dx[i],dy[i]);
			checkProccess(depth+1, sum+lineSum,cnt+1);
			
			toggleVisited(now,dx[i], dy[i]);
		}
		checkProccess(depth+1, sum, cnt);

	}
	
	static boolean checkIsInLine(Point now, int dx, int dy) {
		int nx = now.x;
		int ny = now.y;
		while(true) {
			if(nx==0 || nx==N-1 || ny==0 || ny==N-1) break;
			nx+=dx;
			ny+=dy;
			if(visited[nx][ny]) return true;
		}
		return false;
	}
	
	static int toggleVisited(Point now, int dx, int dy) {
		int cnt =0;
		int nx = now.x;
		int ny = now.y;
		while(true) {
			if(nx==0 || nx==N-1 || ny==0 || ny==N-1) break;
			nx += dx;
			ny += dy;
			visited[nx][ny] = !visited[nx][ny];
			cnt++;
		}
		return cnt;
	}
	
	
	static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x =x;
			this.y =y;
		}
	}
}
