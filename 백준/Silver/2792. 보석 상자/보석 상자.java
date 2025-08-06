import java.io.*;
import java.util.*;

/*
 * 질투심이 최소가 되게
 * 기준 -> 질투심
 * 최소 1 , 최대 치 arr[N-1]
 * mid = 1+최대 / 2
 * 
 * */
public class Main {
	
	static int N;
	static int M;
	static int [] jewels;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(str.nextToken());
		M=Integer.parseInt(str.nextToken());
		
		jewels = new int[M];
		for(int i=0;i<M;i++) {
			jewels[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(jewels);
		
		int lo = 1;
		int hi = jewels[M-1];
		int zelous = 1;
		
		while(lo<hi) {
			int mid = (lo+hi)/2;
			
			if(canDivide(mid) <= N) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}
		zelous = lo;
		System.out.println(zelous);
	}
	
	static int canDivide(int count) {
		int result = 0;
		for(int i=0;i<jewels.length;i++) {
			result += (jewels[i]%count == 0) ? jewels[i]/count : jewels[i]/count+1;
		}
		return result;
	}
	
	
	
}
