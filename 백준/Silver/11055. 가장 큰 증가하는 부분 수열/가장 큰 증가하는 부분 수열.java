
import java.util.*;
import java.io.*;

// 다시 생각해보기  


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		int [] arr = new int[n+1];
		int[] dp = new int[n+1];		

		for(int i=1;i<n+1;i++) {
			arr[i]= Integer.parseInt(str.nextToken());
			dp[i] = arr[i];
		}

		int maxVal=dp[1];
		
		for(int i=1;i<n+1;i++) {
			for(int j=1; j<i; j++) {
				if(arr[j]<arr[i]) {
						dp[i]=Math.max(dp[j]+arr[i], dp[i]);
						maxVal = Math.max(maxVal, dp[i]);
					
				}
			}
		}
		

		
//		System.out.println(Arrays.toString(dp));
		System.out.println(maxVal);

		// index가 0 ~ i-1 중, arr[i] 보다 작은값 중 제일 큰 값.
		// dp에 그 값을 더한 값을 저장

	}

}
