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
static int N, L, R, S;
    static int[][] cases;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
 
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken()); 
            R = Integer.MIN_VALUE;
            S = Integer.MIN_VALUE;
             
            cases = new int[N][2];
             
            for(int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                cases[n][0] = Integer.parseInt(st.nextToken());
                cases[n][1] = Integer.parseInt(st.nextToken());
            }
             
            backtrack(0, 0, 0);
             
            sb.append("#").append(tc).append(" ").append(S).append("\n");
             
        }
        System.out.println(sb);
    }
     
    private static void backtrack(int start, int crrCal, int crrScore) {
        if(crrCal > L) 
            return;
        S = Math.max(S, crrScore);
        for(int i = start; i < N; i++) {
            backtrack(i+1, crrCal + cases[i][1], crrScore + cases[i][0]);
        }
    }
}