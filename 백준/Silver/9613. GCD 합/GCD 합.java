
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<t;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(str.nextToken());
			int [] arr = new int[n];
			for(int j=0;j<n;j++) {
				arr[j]=Integer.parseInt(str.nextToken());
			}
			System.out.println(arrgcd(arr, n));
			
			
		}
		
		
		
		
		
		
	}
	static long arrgcd(int [] arr, int n) {
		long sum=0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				sum+=gcd(arr[i], arr[j]);
			}
		}
		return sum;
	}
	
	static int gcd(int a, int b) {
		int maxVal, minVal;
		if(a>b) {
			maxVal = a;
			minVal = b;
		}else {
			maxVal = b;
			minVal = a;
		}
		while(minVal != 0) {
			int r = maxVal%minVal;
			maxVal = minVal;
			minVal = r;
		}
		return maxVal;
	}

}
