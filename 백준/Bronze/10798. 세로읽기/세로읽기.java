
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str;
		
		String [][] arr = new String[5][15];
		
		String st;
		
		int max_index = 0;
		for(int i=0; i<5; i++) {
			st = br.readLine();
			for(int j=0; j<st.length();j++) {
				arr[i][j]=String.valueOf(st.charAt(j));
			}
			if(max_index<st.length()) {
				max_index=st.length();
			}
		}
		int k=0;
		int l=0;
		while(k<max_index) {
			while(l<5) {
				if(arr[l][k]==null) {
					l++;
					continue;
				}
				bw.write(arr[l][k]);
				l++;
			}
			k++;
			l=0;
		}
		bw.flush();
		bw.close();
		
		
		
	}
}