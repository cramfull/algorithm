
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int P = Integer.parseInt(str.nextToken());
		int N = Integer.parseInt(str.nextToken());
		
		int A [] = new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i=0; i<A.length; i++) {
			A[i]=Integer.parseInt(str.nextToken());
		}
		
		Arrays.sort(A);
		
		int result = 0;
		
		for(int i=0; i<A.length; i++) {
			if(P>=200) {
				break;
			}
			P += A[i];
			result+=1;
		}
		System.out.println(result);
		
	}
}