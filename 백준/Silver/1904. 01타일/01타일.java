
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

//20231117 X 

public class Main {
	static int [] arr;
	static int N;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+2];
		arr[1]=1;
		arr[2]=2;
		System.out.println(fibo(N));
				
				
	}
	
	
	static int fibo(int x) {
		if(arr[x]==0) {
			arr[x] = (fibo(x-1) + fibo(x-2))%15746;
		}
		return arr[x];
	}
}

 