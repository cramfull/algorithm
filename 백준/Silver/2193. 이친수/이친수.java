
import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
	static int N;
	static long [] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new long[N+3];
		
		
		System.out.println(dp(N));
		
	}
	
	static long dp(int k) {
		arr[1]=1;
		arr[2]=1;
		
		if(k<=2) {
			return arr[k];
		}else if(arr[k]!=0) {
			return arr[k];
		}else {
			arr[k]= dp(k-2)+dp(k-1);
			return arr[k];
		}
		
	}
	
	
}