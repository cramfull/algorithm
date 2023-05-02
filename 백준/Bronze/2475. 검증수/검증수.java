
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;




	
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i =0; i<5; i++) {
			int k = Integer.parseInt(str.nextToken());
			sum += k*k;
		}
		
		System.out.println(sum%10);
	}	

}
