
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int L = Integer.parseInt(br.readLine());
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		
		
		int K = 0;
		int M = 0;
		
		if(A%C==0) {
			K= A/C;
		}else {
			K=A/C+1;
		}
		if(B%D==0) {
			M= B/D;
		}else {
			M=B/D+1;
		}
		
		int result = 0;
		if(K<=M) {
			result = L-M;
		}else {
			result = L-K;
		}
		
		System.out.println(result);
		
	}
}