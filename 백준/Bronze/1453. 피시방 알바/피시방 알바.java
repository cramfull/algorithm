
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int N = Integer.parseInt(br.readLine());
		
		int [] arr = new int[100];
		str = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int k = Integer.parseInt(str.nextToken());
			
			arr[k-1]++;
		}
		
		int r = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>1) {
				r += arr[i]-1;
			}
		}
		
		System.out.println(r);
		
		
		
		
		
		
	}
	
	
	
}