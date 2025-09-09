import java.io.*;
import java.util.*;

public class Solution {

	static int N;
	static int [] nums;
	static int [] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=TC;tc++) {
			N = Integer.parseInt(br.readLine());
			nums=new int[N];
			String [] line = br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				nums[i]=Integer.parseInt(line[i]);
			}
			
			arr = new int[N];
			int size=0;
			for(int i=0;i<N;i++) {
				int k = nums[i];
				int idx = Arrays.binarySearch(arr, 0, size, k);
				if(idx<0) {
					idx = -1*(idx+1);
				}
				arr[idx]=k;
				if(idx==size) {
					size++;
				}
			}
			sb.append("#").append(tc).append(" ").append(size).append("\n");
		}
		System.out.println(sb.toString());
	}
}
