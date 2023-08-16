
import java.io.*;
import java.util.*;
	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long sum =0;
		for(int i=N-1; i>=1; i--) {
			sum+=i;
		}
		
		System.out.println(sum);
		System.out.println(2);
		
		
	}
	
	
	

}



