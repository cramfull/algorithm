import java.io.*;
import java.util.*;

/* 그리디로 처음 접근
 * 	-> 제일 가까운 쪽 벽장문을 이동시키려 했는데, 생각해보니 미래의 일까지 그리디하진 않음
 * 결국 dp 아니면 백트랙킹 같은데..
 * dp는 각 depth당 좌/우 중 최소인 부분을 구해야하니 좀 복잡할 것 같고
 * 중복 순열로 backtracking 해보자 
 * 예제를 보면 4번의 움직임에서 좌좌좌좌 -> 우우우우 로 선택하는 모든 경우를 찾으면 될듯 (0000 -> 1111)
 */
public class Main {
	
	static int N, K, result;
	static int [] target;
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int left = Integer.parseInt(str.nextToken());
		int right = Integer.parseInt(str.nextToken());
		
		K = Integer.parseInt(br.readLine());
		target = new int[K];
		for(int i=0;i<K;i++) {
			target[i]=Integer.parseInt(br.readLine());
		}
		result = Integer.MAX_VALUE;
		backTracking(0,0,left, right);
		
		System.out.println(result);
	}
	
	static void backTracking(int depth, int sum, int left, int right) {
		if(sum>result) return;
		
		if(depth == K) {
			result = Math.min(result, sum);
			return;
		}
		
		for(int i=0;i<2;i++) {
			if(i==0) backTracking(depth+1, sum + Math.abs(target[depth]-left), target[depth], right);
			if(i==1) backTracking(depth+1, sum + Math.abs(target[depth]-right), left, target[depth]);
		}
	}
}
