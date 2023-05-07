
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int R1 = Integer.parseInt(str.nextToken());
		int S = Integer.parseInt(str.nextToken());
		
		System.out.println(2*S-R1);
		
		
		
		
	}
}


