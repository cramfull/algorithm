

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer str;
		int [] A = new int[10];
		
		for(int i=0; i<T; i++) {
			str = new StringTokenizer(br.readLine());
			
			for(int j=0; j<A.length; j++) {
				A[j] = Integer.parseInt(str.nextToken());
			}
			
			Arrays.sort(A);
			System.out.println(A[7]);
		}
		
	}
}
