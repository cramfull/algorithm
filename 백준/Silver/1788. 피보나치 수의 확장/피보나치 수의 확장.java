
import java.util.*;
import java.io.*;

public class Main {
	static int dp[];
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		// fibonacci를 dp로 함수 구성
		// 1,000,000,000로 나눈 나머지로 저장
		// 홀/짝 구분
		// 수 구하기 
		
		int isFind = 1;
		
		if(N==0) {
			isFind =0;
		}else if(N<0) {
			N*=-1;
			if(N%2==0) {
				isFind = -1;
			}
		}
		dp = new int[N+2];
		dp[0]=0;
		dp[1]=1;
		int result = fibo(N);
		
		System.out.println(isFind);
		System.out.println(result);
		
		
	}
	
	static int fibo(int n) {
		if(n==0) {
			return dp[0];
		}else if(n==1) {
			return dp[1];
		}else {
			for(int i=2;i<=n;i++) {
				dp[i]=dp[i-2]%1000000000+dp[i-1]%1000000000;
			}
			return dp[n]%1000000000;
		}
	}
	
	
}
