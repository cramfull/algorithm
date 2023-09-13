

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new LinkedHashMap();

		Object [] arr = new String[N];
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), i+1);
		}
		arr =  map.keySet().toArray();
		StringBuilder sb = new StringBuilder();
		
		
		for(int i=0; i<M; i++) {
			String s = br.readLine();
			try {
				int k = Integer.parseInt(s);
				sb.append(arr[k-1]+"\n");
			}catch(Exception e) {
				sb.append(map.get(s)+"\n");
			}
		}
		System.out.println(sb.toString());
		
		
		
	}
	

	
}