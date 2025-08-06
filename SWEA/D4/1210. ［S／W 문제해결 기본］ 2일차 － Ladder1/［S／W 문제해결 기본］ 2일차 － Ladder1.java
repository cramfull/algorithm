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
class Solution{

	static int [][] ladder;
	static boolean [][] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		

		for(int tc=1; tc<=10; tc++) {
			ladder = new int[100][100];
			visited = new boolean[100][100];
			
			// 입력 
			br.readLine();
			for(int i=0;i<100;i++) {
				ladder[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			// 마지막 줄에서 2 찾기
			int nx = 99;
			int ny = findEndPoint();
			visited[nx][ny] = true;

			// 사다리 타기 역순
			int result = climbLadder(nx, ny);
			
			// 출력
			System.out.println(String.format("#%d %d", tc, result));
		}
	}
	
	// 마지막 줄에서 2 찾기
	static int findEndPoint() {
		int ny = 0;
		for(;ny<100;ny++) {
			if(ladder[99][ny]==2) return ny;
		}
		return ny;
	}
	
	// 사다리 타기 역순
	static int climbLadder(int x, int y) {
		while(x>0) {
			// go left
			while(y>=1 && y<100 && !visited[x][y-1] && ladder[x][y-1]==1) {
				y-=1;
				visited[x][y] = true;
			}
			
			// go right
			while(y>=0 && y<99 && !visited[x][y+1] && ladder[x][y+1]==1) {
				y+=1;
				visited[x][y] = true;
			}
			
			// go up
			if(x>0) {
				x-=1;
				visited[x][y] = true;
			}
			
		}
		
		return y;
	}
}
