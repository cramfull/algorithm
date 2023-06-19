
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char [] input = br.readLine().toCharArray();
		
		for(int i=0; i<input.length; i++) {
			if(65<=(int)input[i] && (int)input[i]<=90) {
				String tmp = String.valueOf(input[i]);
				System.out.print(tmp.toLowerCase());

			}else {
				String tmp = String.valueOf(input[i]);
				
				System.out.print(tmp.toUpperCase());
			}
		}
		
		
		   
		
		
	}
	
	
	
}