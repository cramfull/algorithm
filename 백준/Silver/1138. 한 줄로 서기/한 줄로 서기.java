
import java.util.*;
import java.io.*;


public class Main {

	static int N;
	static int [] weight;
	static int [] arr;
	static int idx;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		weight = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			weight[i] = Integer.parseInt(str.nextToken());
		}
		
		arr = new int[N];
		
		
		
		arr[weight[0]]=1;
		
		for(int i=2;i<=N;i++) {
			idx = 0;
			moveIndexUntilBlank(weight[i-1]);
			moveIndexUntilNextBlanck();
			arr[idx] = i;
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	
	static void moveIndexUntilBlank(int blankTotal) {
		int blankCount = 0;
		for(int i=0;i<N;i++) {
			if(blankCount==blankTotal) return;
			if(arr[i]==0) blankCount++;
			idx++;
		}
	}
	
	static void moveIndexUntilNextBlanck() {
		for(int i=idx; i<N;i++) {
			if(arr[i]==0) return;
			idx++;
		}
	}

}
