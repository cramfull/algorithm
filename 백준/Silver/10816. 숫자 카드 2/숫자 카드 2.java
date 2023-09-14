

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int input1 = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<input1; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(map.containsKey(k)) {
				map.put(k, map.get(k)+1);		
			}else {
				map.put(k, 1);
			}
		}
		
		int input2 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<input2; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(map.containsKey(k)) {
				sb.append(map.get(k)+" ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb.toString());
		
		
	}
	

	
}