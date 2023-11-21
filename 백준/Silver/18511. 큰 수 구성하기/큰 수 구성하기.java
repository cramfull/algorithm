
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int resultMax;
	static int N;
	static int [] arr;
	static int [] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(br.readLine());
		arr = new int[K];
		for(int i=0;i<K;i++) {
			arr[i]=Integer.parseInt(str.nextToken());
		}
		for(int i=String.valueOf(N).length(); i>0;i--) {
			result = new int[i];
			backTracking(0);
		}
		System.out.println(resultMax);
		
			
	}
	static void backTracking(int x) {
		String tmp="";
		for(int i=result.length-1;i>=0;i--) {
			tmp+=String.valueOf(result[i]);
		}
		if(Integer.parseInt(tmp)<=N&& Integer.parseInt(tmp)>=resultMax) {
			resultMax = Integer.parseInt(tmp);
		}
		
		if(x==result.length) {
			if(Integer.parseInt(tmp)!=0) {
				return;
			}
		}else {
			for(int i=0;i<arr.length;i++) {
				result[x]=arr[i];
				backTracking(x+1);
			}
		}
		
		
		
		
		
		
	}
	
	
	
}