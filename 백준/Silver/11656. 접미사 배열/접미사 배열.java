
import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String st = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		sb.append(st);
		
		String [] arr = new String[st.length()];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sb.toString();
			sb.deleteCharAt(0);
		}
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			bw.write(arr[i]);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
	

}



