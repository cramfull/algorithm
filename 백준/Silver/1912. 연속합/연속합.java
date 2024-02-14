
import java.io.*;
import java.util.*;
import java.math.*;

// https://www.acmicpc.net/problem/2644

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N+1];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=1;i<arr.length;i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		int maxValue = arr[1];
		for(int i=2;i<arr.length;i++) {
			maxValue = Math.max(maxValue, arr[i]);
		}
		
		if(maxValue < 0) {
			
		}else {
			int [] dp = new int[N+1];
			maxValue = dp[1];
			for(int i=1;i<dp.length;i++) {
				if(dp[i-1]+arr[i]>0) {
					dp[i]=dp[i-1]+arr[i];
				}else {
					dp[i]=0;
				}
				if(maxValue<dp[i]) {
					maxValue=dp[i];
				}
			}
		}
		System.out.println(maxValue);
	}
}