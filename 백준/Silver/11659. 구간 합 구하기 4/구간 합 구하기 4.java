
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		int [] srr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(str.nextToken());
			if(i==0) {
				srr[0]=arr[0];
			}else {
				srr[i]=srr[i-1]+arr[i];
			}
		}
		for(int i=0;i<M;i++) {
			str = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(str.nextToken());
			int ed = Integer.parseInt(str.nextToken());
			if(st==1) {
				sb.append(srr[ed-1]);
			}else if(st==ed){
				sb.append(arr[st-1]);
			}else {
				sb.append(srr[ed-1]-srr[st-2]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}