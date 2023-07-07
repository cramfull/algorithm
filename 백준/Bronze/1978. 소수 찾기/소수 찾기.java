
import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String [] nums = br.readLine().split(" ");
		int result = 0;
		for(int i=0; i<N; i++) {
			boolean check = false;
			int tmp = Integer.parseInt(nums[i]);
			
			for(int j=1; j<tmp; j++) {
				if(tmp%j==0 && j!=1) {
					check = true;
				}
			}
			if(check) {
				continue;
			}else if(tmp!=1){
				result++;
			}
			
		}
		System.out.println(result);
		
		
	}
}