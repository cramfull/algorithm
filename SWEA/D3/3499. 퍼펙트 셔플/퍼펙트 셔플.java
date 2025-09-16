import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static String [] results;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			results = new String[N];
			String [] line = br.readLine().split(" ");
			int even = (N%2 != 0) ? N/2+1 : N/2;
			int oddEnd = (N%2 != 0) ? N-1 : N;
			for(int i=0;i<even;i++) {
				results[2*i] = line[i];
			}
			for(int i=N/2;i<oddEnd;i++) {
				if(N%2==0){
					results[2*(i-N/2)+1] = line[i];
				}else {
					results[2*(i-N/2)+1] = line[i+1];
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<N;i++) {
				sb.append(results[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
