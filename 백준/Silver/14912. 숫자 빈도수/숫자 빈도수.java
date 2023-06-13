
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer str = new StringTokenizer(br.readLine());
		String num = str.nextToken();
		char check = str.nextToken().charAt(0);
		
		System.out.println(find(num, check));
		
	}
	
	static int find(String num, char check) {
		int count =0;
		for(int i=1; i<=Integer.parseInt(num); i++) {
			String tmp = String.valueOf(i);
			for(int j=0; j<tmp.length(); j++) {
				if(tmp.charAt(j)==check) {
					count++;
				}
			}
		}
		return count;
		
	}
}