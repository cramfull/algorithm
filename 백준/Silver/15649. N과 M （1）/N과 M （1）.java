
import java.util.Arrays;
import java.util.Scanner;



public class Main {
	//값을 담을 배열 
	static int [] arr;
	//해당 인덱스 x에 탐색 여부를 검사하기 위한 boolean형 배열 
	static boolean check[];
	
	static void backTraking(int x, int N, int M) {
		// 재귀의 끝, x가 M이랑 같은 시점에 arr에 담은 값 출력 
		if(x == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}else {
			for(int i =1; i<= N; i++) {
				// 검사한 배열이 false일 경우 
				if(!check[i]) {
					// 해당 인덱스를 탐색한 상태로 변경, 배열에 값 저장 
					check[i] = true;
					arr[x] = i;
					// 다음 인덱스를 탐색하기 위해 x 를 1 증가 시키면서 재귀호출 
					backTraking(x+1, N, M);
					// 다음 탐색을 위해 탐색하지 않은 상태로 변경 
					check[i] = false;
				}
			}
		}
	}
	
    public static void main(String[] args){
       Scanner scn = new Scanner(System.in);
       int N = scn.nextInt();
       int M = scn.nextInt();
       
       arr = new int[M+1];
       check = new boolean[N+1];
       backTraking(0, N, M);

	}

}