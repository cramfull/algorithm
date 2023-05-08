
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static String star(int N) {
		String star = "*";
		String blank = " ";
		String result = "";
		for(int i = 0; i<N; i++) {
			for(int j=0; j<i; j++) {
				result+= blank;
			}
			for(int k=2*(N-i)-1; k>0; k--) {
				result+= star;
			}
			result+="\n";
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(Main.star(N));
		
		
	}
}


