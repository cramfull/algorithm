
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int a = Integer.parseInt(br.readLine());
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		int [] A = new int [a];
		for(int i = 0 ; i<a; i++) {
			A[i] = Integer.parseInt(str.nextToken());
		}
		int result = 0;
		Arrays.sort(A);
		if(a==1) {
			result = A[0]*A[0];
		}else if(a%2==0) {
			result = A[0]*A[A.length-1];
		}else {
			result = A[0]*A[A.length-1];
		}
		
		
		System.out.println(result);
	}
	
}