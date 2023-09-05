
import java.io.*;

import java.util.*;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<String, Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		String [] arr = new String[7];
		int time [] = {4, 6, 4, 10};
		for(int i=0; i<4*N; i++) {
			int k = time[i%4];
			arr = br.readLine().split(" ");
			for(int j=0; j<arr.length; j++) {
				String s = arr[j];
				if(s.equals("-")) {
					continue;
				}else if(map.containsKey(s)){
					map.put(s, map.get(s)+k);
				}else {
					map.put(s, k);
				}	
			}
		}
		if(map.size()==0) {
			System.out.println("Yes");
			return;
		}
		Integer maxValue = Collections.max(map.values());
		Integer minValue = Collections.min(map.values());
		
		if(maxValue-minValue<=12) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
	}
}