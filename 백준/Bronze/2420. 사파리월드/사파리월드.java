
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer str = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(str.nextToken());
		long M = Integer.parseInt(str.nextToken());
		
		long result = N-M;
		if(result<0) {
			result *= -1;
		}
		System.out.println(result);
		
	}
}