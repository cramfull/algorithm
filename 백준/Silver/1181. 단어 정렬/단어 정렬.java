

import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		String [] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		Set<String> set = new HashSet<>();
		
		for(int i=0; i<N; i++) {
			set.add(arr[i]);
		}
		
		ArrayList<String> list = new ArrayList<String>(set);
		
		Collections.sort(list, new Comparator<>(){
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}else {
					return s1.length() - s2.length();
				}
			}
		});
		

		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	
	}
}