
import java.io.*;

import java.util.*;
import java.util.Map.Entry;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<Integer ,Integer> map = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int same =0;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			map.put(Integer.parseInt(st.nextToken()), null);
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int s = Integer.parseInt(st.nextToken());
			if(map.containsKey(s)) {
				same++;
			}else {
				map.put(s, null);
			}
		}
		
		System.out.println(map.size()-same);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}