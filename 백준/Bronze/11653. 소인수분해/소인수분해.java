

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		if(N==1) {
			return;
		}else {
			int i=2;
			while(N!=1) {
				if(N%i==0) {
					bw.write(String.valueOf(i));
					bw.newLine();
					N=N/i;
					continue;
				}else {
					i++;
					continue;
				}
			}
			
			
			
		}
		
		bw.flush();
		bw.close();
		
		
		
		}
	
}