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
    static int [] gyuyoung;
	static int [] inyoung;
	static int winningPoint;
	static int [] arr;
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			arr = new int[9];
			visited = new boolean[9];
			winningPoint = 0;
			
			gyuyoung = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<=18; i++) {
				set.add(i);
			}
			
			for(int i=0;i<9;i++) {
				if(set.contains(gyuyoung[i])) set.remove(gyuyoung[i]);
			}
			inyoung = set.stream().mapToInt(Integer::intValue).toArray();
		
			backTracking(0);
			
			System.out.println(String.format("#%d %d %d", tc, winningPoint, 362880-winningPoint));
			
		}
	}
	
	static void backTracking(int depth) {
		if(depth==9) {
			if(checkWinningPoint()) {
				winningPoint+=1;
			}
			return;
		}
		
		for(int i=0;i<9;i++) {
			if(visited[i]) continue;
			
			arr[depth] = inyoung[i];
			visited[i] = true;
			backTracking(depth+1);
			visited[i] = false;
		}
	}
	
	static boolean checkWinningPoint() {
		int point = 0;
		for(int i=0;i<9;i++) {
			if(gyuyoung[i]>arr[i]) {
				point+=gyuyoung[i]+arr[i];
				if(point>85) {
					return true;
				}
			}
		}
		return false;
	}
}
