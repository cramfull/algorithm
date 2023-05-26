
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;



	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(str.nextToken());
		long B = Long.parseLong(str.nextToken());
		long result = 0;
		
		if(A<B) {
			result = (A+B)*((B-A+1)/2);
			if((B-A)%2==0) {
				result+=(A+B)/2;
			}
		}else {
			result = (B+A)*((A-B+1)/2);
			if((A-B)%2==0) {
				result+=(B+A)/2;
			}
		}
		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		
	}	
}