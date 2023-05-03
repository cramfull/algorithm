
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(str.nextToken());
		int P = Integer.parseInt(str.nextToken());
		
		
		long [] inCome = new long[5];
		
		str = new StringTokenizer(br.readLine());
		
		for(int i = 0 ; i<5; i++) {
			inCome[i] = Long.parseLong(str.nextToken()) - L*P ;
			
			
		}
		
		
		String result="";
		for(int i =0; i<5; i++) {
			result += inCome[i];
			if(i<4) {
				result += " ";
			}
		}
		System.out.println(result);
	
	
	}

}
