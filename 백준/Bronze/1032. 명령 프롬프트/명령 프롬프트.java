

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static String [] promptStr;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0; i<N; i++) {
			if(i==0) {
				promptStr = br.readLine().split("");
			} else {
				Main.prompt(br.readLine());
			}
		}
		String result = String.join("",promptStr);
		System.out.println(result);
		
		
	}
	
	public static void prompt(String str) {
		String [] compareStr = str.split("");
		
		for(int i=0; i<str.length(); i++) {
			if(!(promptStr[i].equals(compareStr[i]))) {
				promptStr[i]="?";
			}
		}
		
	}
	
}
