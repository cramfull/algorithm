


import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int [] str = new int [N];
		for(int i =0; i<N; i++) {
			str[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(str);
		for(int i=0; i<N; i++) {
			bw.write(String.valueOf(str[i]));
			bw.newLine();
		}
		
		bw.flush();
		bw.close();
	}
}











