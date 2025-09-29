import java.io.*;
import java.util.*;

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
			if(i==0) {
				backTracking(depth+1, sum + Math.abs(target[depth]-left), target[depth], right);
			}
			if(i==1) {
				backTracking(depth+1, sum + Math.abs(target[depth]-right), left, target[depth]);
			}
		}
	}
}
