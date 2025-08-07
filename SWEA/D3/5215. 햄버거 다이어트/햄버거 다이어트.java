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
class Solution {
	
	static int result;
		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer str;
		for(int tc=1; tc<=TC; tc++) {
			str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int L = Integer.parseInt(str.nextToken());
			Pair [] ingredients = new Pair[N];
			boolean [] visited = new boolean[N];
			result = 0;
			for(int i=0;i<N;i++) {
				str = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(str.nextToken());
				int K = Integer.parseInt(str.nextToken());
				ingredients[i] = new Pair(T, K);
			}
			
			powerSet(ingredients, visited, N, L, 0);

			sb.append(String.format("#%d %d", tc, result)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	static void powerSet(Pair [] ingredients, boolean [] visited, int N, int L, int depth) {
		if(depth == N) {
			int scoreSum = 0;
			int kcalSum = 0;
			for(int i=0;i<N;i++) {
				if(visited[i]) {
					Pair ingredient = ingredients[i];
					scoreSum+= ingredient.score;
					kcalSum += ingredient.kcal;
					if(kcalSum<=L) {
						result = Math.max(result,scoreSum);
					}
				}
			}
			return;
		}
		
		visited[depth] = false;
		powerSet(ingredients, visited, N, L, depth+1);
		
		visited[depth] = true;
		powerSet(ingredients, visited, N, L, depth+1);
	}
	
	static class Pair{
		int score;
		int kcal;
		
		public Pair(int score, int kcal) {
			this.score = score;
			this.kcal = kcal;
		}
	}
}
