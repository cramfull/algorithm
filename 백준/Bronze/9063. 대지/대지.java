


import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arrX [] = new int[N];
		int arrY [] = new int[N];
		StringTokenizer str;
		for(int i=0; i<N; i++) {
			str = new StringTokenizer(br.readLine());
			arrX[i]= Integer.parseInt(str.nextToken());
			arrY[i]= Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arrX);
		Arrays.sort(arrY);
		
		int result = (arrX[N-1]-arrX[0])*(arrY[N-1]-arrY[0]);
		if(result<0) {
			result*=-1;
		}
		System.out.println(result);
		
		
		
		
	}
}











