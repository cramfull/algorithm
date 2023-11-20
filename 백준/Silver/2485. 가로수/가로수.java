
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		int [] arr2 = new int[n-1];
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=arr[i+1]-arr[i];
		}
		int k= gcd(arr2[1],arr2[0]);
		for(int i=2;i<arr2.length;i++) {
			k = gcd(k,arr2[i]);
		}

		
		
		int l = (arr[arr.length-1] - arr[0])/k+1;
		
		System.out.println(l-arr.length);
		
	}
	static int gcd(int a, int b) {
		
		if(b==0) {
			return a;
		}else {

			return gcd(b, a%b);
		}
		
		
		
	}
}