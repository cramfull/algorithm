

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String s = "";
		Set<String> set = new HashSet<>();
		int result =0;
		
		for(int i=0; i<N; i++) {
			s = br.readLine();
			if(s.equals("ENTER")) {
				result += set.size();
				set = new HashSet<>();
			}else {
				set.add(s);
			}
		}
		result+=set.size();

		System.out.println(result);
		
		
		
		
		
		
	}
	

	
}