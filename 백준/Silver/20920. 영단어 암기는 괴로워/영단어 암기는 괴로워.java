
import java.io.*;

import java.util.*;
import java.util.Map.Entry;


public class Main {	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new TreeMap<>();
		
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			if(s.length()<M) {
				continue;
			}
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if(o2.getValue() - o1.getValue() != 0) {
					
					return o2.getValue() - o1.getValue();
				}
				
				if(o1.getKey().length() - o2.getKey().length() != 0) {
					return o2.getKey().length() - o1.getKey().length();
				}
				
				return o1.getKey().compareTo(o2.getKey());
			}
			
		});
		StringBuilder sb = new StringBuilder();
		for(Entry<String, Integer> entry : list) {
			sb.append(entry.getKey()+"\n");
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}
}