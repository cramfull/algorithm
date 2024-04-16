
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int [] nums;
//	static int [] result;
//	static int [] oprC;
	static long maxV = -1000000000;
	static long minV = 1000000000;
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer str = new StringTokenizer(br.readLine());
		nums = new int[N];
		int result[];
		int oprC[];
		result = new int[N-1];
		oprC = new int[N-1];
		boolean [] used = new boolean[N-1];
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(str.nextToken());
		}
		str = new StringTokenizer(br.readLine());
		int [] tmp = new int[5];
		for(int i=1;i<5;i++) {
			tmp[i]=Integer.parseInt(str.nextToken());
			// oprC[1] + 
			// oprC[2] -
			// oprC[3] *
			// oprC[4] / 
		}
		int idxT = 1;
		int idxO = 0;
		while(idxT<tmp.length) {
			if(tmp[idxT]==0) {
				idxT++;
			}else {
				tmp[idxT]-=1;
				oprC[idxO++]=idxT;
			}
		}
		
		backtracking(result, used, oprC, 0);
		System.out.println(maxV);
		System.out.println(minV);
	}
	
	static long cal(int [] result) {
		int idx=0;
		long sum = nums[idx++];
		
		for(int i=0;i<N-1;i++) {
			if(result[i]==1) {
				sum+=nums[idx++];
			}else if(result[i]==2) {
				sum-=nums[idx++];
			}else if(result[i]==3) {
				sum*=nums[idx++];
			}else {
				sum/=nums[idx++];
			}
		}
		return sum;
	}
	
	static void backtracking(int [] result, boolean [] used, int [] oprC, int x) {
//		System.out.println(Arrays.toString(result));
		if(x==N-1) {
			long tmp = cal(result);
			minV = Math.min(tmp, minV);
			maxV = Math.max(tmp, maxV);
			return;
		}else {
			for(int i=0; i<oprC.length;i++) {
				if(!used[i]) {
					used[i]=true;
					result[x]=oprC[i];
					backtracking(result, used, oprC, x+1);
					used[i]=false;
				}
			}
		}
	}

}
