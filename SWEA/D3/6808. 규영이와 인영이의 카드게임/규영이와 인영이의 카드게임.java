import java.io.*;
import java.util.*;

class Solution{

	static int [] gyuyoung;
	static int [] inyoung;
	static int winningPoint;
	static int [] arr;
	static boolean [] visited;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC; tc++) {
			arr = new int[9];
			visited = new boolean[9];
			winningPoint = 0;
			
			// 전체 카드 
			Set<Integer> set = new HashSet<>();
			for(int i=1; i<=18; i++) {
				set.add(i);
			}
			
			// 규영이 카드 입력
			gyuyoung = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			// 전체 카드에서 규영이 카드를 빼서 
			Arrays.stream(gyuyoung).forEach(set::remove);
			
			// 인영이 카드 생성 
			inyoung = set.stream().mapToInt(Integer::intValue).toArray();
		
			// 순열로 카드 패 생성 
			backTracking(0);
			
			// 승리 횟수, 9!-승리횟수 
			sb.append(String.format("#%d %d %d", tc, winningPoint, 362880-winningPoint)).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	/**
	 * 순열 생성, depth 가 최종 도달 시, 승점 계산
	 * @param depth 깊이 == 순열의 원소 index
	 */
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
	
	/**
	 * 규영이 기준 승리했는가 승점 체크하는 메서드 
	 * 승점은 총 19*9 = 171점으로, 85|86 승자가 나뉨
	 * 86점 이상 취득 시 승자
	 * @return true 승리 : false 패배 
	 */
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
