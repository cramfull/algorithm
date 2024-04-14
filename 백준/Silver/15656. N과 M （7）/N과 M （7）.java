
import java.util.*;
import java.io.*;


public class Main {
	static int N,M;
	static int nums[];
	static int result[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		M = Integer.parseInt(str.nextToken());
		nums = new int[N];
		result = new int[N+1];
		str = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(str.nextToken());
		}
		Arrays.sort(nums);
		backTracking(0);
		System.out.println(sb.toString());
	}
	
	static void backTracking(int x) {
		if(x==M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
		}else {
			for(int i=0;i<N;i++) {
				result[x]=nums[i];
				backTracking(x+1);
			}
		}
		
		
		
		
		
		
	}

}
