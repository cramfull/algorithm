import java.io.*;
import java.math.*;
import java.util.*;

//20231117 X 

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
		 * dp 테이블 생성
		 * 입력 받고
		 * for문 돌림
		 * if 부분
		 */
		int [] dp = new int[12];
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(dp[input]==0) {
				for(int j=4;j<=input;j++) {
					dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
				}
			}
			System.out.println(dp[input]);
		}	
	}
}