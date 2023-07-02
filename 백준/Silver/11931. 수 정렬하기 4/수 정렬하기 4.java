
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		Integer [] arr = new Integer[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for(int i=0; i<arr.length; i++) {
			bw.write(String.valueOf(arr[i]));
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}