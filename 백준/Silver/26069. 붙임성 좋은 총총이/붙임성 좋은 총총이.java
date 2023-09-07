
import java.io.*;

import java.util.*;
import java.util.Map.Entry;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int value =0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			if(a.equals("ChongChong") || b.equals("ChongChong")) {
				value = 1;
				map.put(a, value);
				map.put(b, value);
			}
			chong(map, a, b);
			chong(map, b, a);
			
			
		}
		int result =0;
		for(String str : map.keySet()) {
			result += map.get(str);
		}
		System.out.println(result);

		
		
	}
	public static void chong(Map<String, Integer> map, String s1, String s2) {
		if(map.containsKey(s1)) {
			map.put(s2, 1);
		}
	}
	
}