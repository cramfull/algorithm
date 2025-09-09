import java.io.*;
import java.util.*;

/* 0909 11:30
 * 나무높이
 * 홀수 필요날, 짝수 필요날
 * 
 */
public class Solution {
	
	static int N, maxHeight, result;
	static int [] heights;
	static int [] diff;
	
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			String [] line = br.readLine().split(" ");
			heights = new int[N];
			maxHeight = Integer.MIN_VALUE;
			for(int i=0;i<N;i++) {
				heights[i] = Integer.parseInt(line[i]);
				maxHeight = Math.max(maxHeight, heights[i]);
			}
			
			diff = new int[N];
			for(int i=0;i<N;i++) {
				diff[i]=maxHeight-heights[i];
			}
			
			int odd = 0;
			int even = 0;
			result = 0;
			for(int i=0;i<N;i++) {
				odd+=diff[i]%2;
				even+=diff[i]/2;
			}
			if(odd==even) {
				result = even*2;
			}else if(odd>even) {
				result = odd*2-1;
			}else if(odd<even) {
				int n = (even-odd+1)/3;
				even-=n;
				odd+=2*n;
				if(odd<=even) {
					result = even*2;
				}else if(odd>even) {
					result = odd*2-1;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
	}
}
