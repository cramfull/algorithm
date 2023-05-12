

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int charge = 1000 - T;
		int result = charge/500 + (charge%500)/100 + ((charge%500)%100)/50 + (((charge%500)%100)%50)/10+((((charge%500)%100)%50)%10)/5 + (((((charge%500)%100)%50)%10)%5)/1;
		System.out.println(result);
		
	}
}
