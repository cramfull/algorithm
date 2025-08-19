
import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, maxHeight;
	static int [] trees, needWaters;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			maxHeight = Integer.MIN_VALUE;
			trees = new int[N];
			needWaters = new int[N];
			
			StringTokenizer  str = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				trees[i] = Integer.parseInt(str.nextToken());
				maxHeight = Math.max(maxHeight, trees[i]);
			}
			
			for(int i=0;i<N;i++) {
				needWaters[i] = maxHeight - trees[i];
			}
			
			int resultDays = countDays();
			
			sb.append("#").append(tc).append(" ").append(resultDays).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	static int countDays() {
		int even = 0;
		int odd = 0;
		
		for(int i=0;i<N;i++) {
			even += needWaters[i]/2;
			odd += needWaters[i]%2;
		}
		
								// 홀-짝이 같을 때
		if(odd == even) {
			return even*2;
		}else if(odd > even) { 	// 홀이 더 클 때
			return odd*2-1;
		}else { 				// 짝이 더 클 때
			int n = (even - odd +1)/3;
			even -= n;
			odd += 2*n;
		}
		
		return (odd > even) ? odd*2-1 : even*2;
	}
}