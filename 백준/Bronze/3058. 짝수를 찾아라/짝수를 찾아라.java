
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;




	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer str;
		//N 받기
		//N번 반복
		//배열안에 넣고 sort reverse, 마지막 짝수
		Integer [] nums = new Integer[7];
		
		for(int i=0; i<N; i++) {
			str=new StringTokenizer(br.readLine());
			int sum=0;		
			int k=0;

			for(int j=0; j<7; j++) {
				nums[j]=Integer.parseInt(str.nextToken());
			}
			Arrays.sort(nums, Collections.reverseOrder());
			for(int l=0; l<nums.length; l++) {
				if(nums[l]%2==0) {
					sum+=nums[l];
					k=nums[l];
				}
			}
			System.out.println(sum+" "+k);
		}
		
		
	}	

}
