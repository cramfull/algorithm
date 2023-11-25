
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int N;
	static int [] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+2];
		arr[1]=1;
		arr[2]=2;
		System.out.println(dp(N));
	
	
	}
	static int dp(int x) {
		if(x<=2) {
			return arr[x];
		}else if(arr[x]!=0){
			return arr[x];
		}else {
			arr[x]=(dp(x-1)+dp(x-2))%10007;
			return arr[x];
		}
	}
}

