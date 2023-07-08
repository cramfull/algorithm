
import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int M = Integer.parseInt(str.nextToken());
		int [] nums = new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(str.nextToken());
		}
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<nums.length-2; i++) {
			for(int j=i+1; j<nums.length-1; j++) {
				for(int k=j+1; k<nums.length; k++) {
					int tmp = nums[i]+nums[j]+nums[k];
					if(tmp<=M) {
						arr.add(tmp);
					}
				}
			}
		}
		arr.sort(Comparator.naturalOrder());
		System.out.println(arr.get(arr.size()-1));
	}
}