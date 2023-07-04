
import java.io.*;
import java.util.*;

public class Main {
	static String st="";

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(str.nextToken());
		int K = Integer.parseInt(str.nextToken());
		
		int [] arr = new int[N];
		str = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(str.nextToken());
		}
		
		selection_sort(arr, N, K);
		
	}
	
	static void selection_sort(int [] arr,int N,int K) {
		int count = 0;
		for(int last = N-1; last>0; last--) {
			int max_value = arr[last];
			int max_index = last;
			for(int i=0; i<last; i++) {
				if(arr[i]>max_value) {
					max_value = arr[i];
					max_index = i;
				}
			}
			if(max_value != arr[last]) {
				int tmp = arr[last];
				arr[max_index]= tmp;
				arr[last] = max_value;
				count++;
			}
			if(count == K) {
				for(int i=0; i<arr.length; i++) {
					st += arr[i];
					if(i<arr.length) {
						st+= " ";
					}
				}
				System.out.println(st);
			}
		}
		if(count<K) {
			System.out.println(-1);
		}
	}
}