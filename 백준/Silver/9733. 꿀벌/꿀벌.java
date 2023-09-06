
import java.io.*;

import java.util.*;
import java.util.Map.Entry;


public class Main {	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		String [] HoneyBee = {"Re", "Pt", "Cc", "Ea", "Tb", "Cm", "Ex"};
		for(int i=0; i<HoneyBee.length; i++) {
			map.put(HoneyBee[i], 0);
		}
		
		StringTokenizer st;
		int total =0;
		String input = br.readLine();
		while (input!=null&&!input.equals("")) {
			st = new StringTokenizer(input);
			while(st.hasMoreTokens()) {
				total++;
				String s = st.nextToken();
				if(map.containsKey(s)) {
					map.put(s, map.get(s)+1);
				}
			}
			input = br.readLine();
		}
		
		
		for(Entry<String, Integer> entrySet : map.entrySet()) {
			float tmp = entrySet.getValue();
			float k = tmp/total;
			String result = String.format("%.2f", k);
			System.out.println(entrySet.getKey()+" "+entrySet.getValue()+" "+result);
		}
		System.out.println("Total "+total+ " 1.00");

		
	}
}