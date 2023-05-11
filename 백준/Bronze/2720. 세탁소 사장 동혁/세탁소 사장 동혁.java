

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int C;
		for(int i=0; i<T; i++) {
			C = Integer.parseInt(br.readLine());
			
			System.out.println(C/25+" "+(C%25)/10+" "+((C%25)%10)/5+" "+(((C%25)%10)%5)/1);
			
			
			
		}
		
	}
}
