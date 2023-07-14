


import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		String [] str = new String[N];
		
		for(int i=0; i<N; i++) {
			String st = br.readLine();
			int result = 0;
			for(int j=0; j<st.length(); j++) {
				if(st.charAt(j)==' ') {
					continue;
				}
				result += st.charAt(j)-64;
			}
			if(result==100) {
				bw.write("PERFECT LIFE");
				bw.newLine();
			}else {
				bw.write(String.valueOf(result));
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
		
		
		
		
		
		
		
	}
}











