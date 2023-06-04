


import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(str.nextToken());
		int B = Integer.parseInt(str.nextToken());
		
		str= new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int [] ch = new int [N];
		int [] n_ch = new int[N];
		
		
		
		for(int i=0; i<N; i++) {
			ch[i] = Integer.parseInt(br.readLine());
			n_ch[i] = B - ch[i];
			if(n_ch[i]<0) {
				n_ch[i]*=-1;
			}
			
		}
		int minVal =n_ch[0];
		for(int i=1; i<N; i++) {
			if(minVal>n_ch[i]) {
				minVal = n_ch[i];
			}
		}
		
		int n_A = B-A;
		if(n_A<0) {
			n_A *= -1;
		}
		
		int result =0;
		
		if(n_A<=minVal) {
			result = n_A;
		}else {
			result = minVal+1;
		}
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
		
		
		
		
		
		
		
		
		
		
		
	}
}