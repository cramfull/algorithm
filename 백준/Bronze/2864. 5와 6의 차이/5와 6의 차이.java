
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		String [] A = str.nextToken().split("");
		String [] B = str.nextToken().split("");
		
		for(int i=0; i<A.length; i++) {
			if(A[i].equals("6")) {
				A[i]="5";
			}
			if(B[i].equals("6")) {
				B[i]="5";
			}
		}
		String resultA = String.join("",A);
		String resultB = String.join("",B);
		
		int result1 = Integer.parseInt(resultA)+Integer.parseInt(resultB);
		

		for(int i=0; i<A.length; i++) {
			if(A[i].equals("5")) {
				A[i]="6";
			}
			if(B[i].equals("5")) {
				B[i]="6";
			}
		}
		resultA = String.join("",A);
		resultB = String.join("",B);
		
		int result2 = Integer.parseInt(resultA)+Integer.parseInt(resultB);
		
		System.out.println(result1+" "+result2);
		
		
	}
	
	
}