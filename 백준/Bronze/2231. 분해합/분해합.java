
import java.util.*;
import java.io.*;


public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean isFind = false;
		int result =0;
		for(int i=1; i<N; i++) {
			int check = 0;
			String num = String.valueOf(i);
			for(int j=0; j<num.length(); j++) {
				int val = Integer.parseInt(String.valueOf((num.charAt(j))));
				check+=val;
			}
			check+=i;

			if(check == N) {
				result = i;
				isFind = true;
				break;
			}
			
		}

		System.out.println(result);
		
	}
}