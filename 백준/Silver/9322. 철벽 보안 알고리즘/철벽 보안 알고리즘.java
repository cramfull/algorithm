

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			Map<String, Integer> map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
		
		
			st = new StringTokenizer(br.readLine());
			
			for(int k=0; k<N; k++) {
				map.put(st.nextToken(), k);
			}
			
			st = new StringTokenizer(br.readLine());
			int [] arr = new int[N];
			
			for(int k=0; k<N; k++) {
				arr[k] = map.get(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			Map<Integer, String >map2 = new TreeMap<>();
			for(int k=0; k<N; k++) {
				map2.put(arr[k],st.nextToken());
			}
			for(String str : map2.values()) {
				bw.write(str+" ");
			}
			bw.newLine();
			
			
		}
		bw.flush();
		bw.close();
		
	}
}