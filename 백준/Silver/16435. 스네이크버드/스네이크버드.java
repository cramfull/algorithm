
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int L = Integer.parseInt(str.nextToken());
		
		str = new StringTokenizer(br.readLine());
		
		int [] arr = new int[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<=L) {
				L++;
			}else {
				break;
			}
		}
		System.out.println(L);
		
	}
}