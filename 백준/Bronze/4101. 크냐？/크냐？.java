
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = br.readLine();
		while(!input.equals("0 0")) {
			StringTokenizer str = new StringTokenizer(input);
			int A = Integer.parseInt(str.nextToken());
			int B = Integer.parseInt(str.nextToken());
			
			if(A>B) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
			input = br.readLine();
		}
		
		
		
		
	}
}