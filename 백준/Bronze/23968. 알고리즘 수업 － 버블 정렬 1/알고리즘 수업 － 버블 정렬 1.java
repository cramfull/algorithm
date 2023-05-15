

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken()), cnt=0;
		int [] A = new int [N];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		
		for(int last = N-1; last>=0; last--) {
			for(int i=0; i<=last-1; i++) {
				if(A[i]>A[i+1]) {
					int tmp = A[i];
					A[i] = A[i+1];
					A[i+1] = tmp;
					count++;
					if(count==K) {
						System.out.println(A[i]+" "+A[i+1]);
						return;
					}
				}
				
			}
		}
		if(count<K) {
			System.out.println(-1);
		}
		
		
		
	}
}
		
		
		
		
		
