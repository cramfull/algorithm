

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new TreeMap<>();
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				map.put(s, map.get(s)+1);
			}else {
				map.put(s, 1);
			}
		}
		List<Map.Entry<String, Integer>> arr = new LinkedList<>(map.entrySet());
		Collections.sort(arr, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				// TODO Auto-generated method stub
				return o2.getValue() - o1.getValue();
			}
		});
		bw.write(arr.get(0).getKey());
		bw.flush();
		bw.close();
		
		
	}
}