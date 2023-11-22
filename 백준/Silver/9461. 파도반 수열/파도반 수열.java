
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static long [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine())-1;
			arr = new long[N+3];
			arr[0]=arr[1]=arr[2]=1;
			System.out.println(dp(N));
			
		}
		
		
	}
	
	static long dp(int N) {
		if(arr[N]==0) {
			arr[N]=dp(N-3)+dp(N-2);
		}
		return arr[N];

		
		
		
	}
	
}