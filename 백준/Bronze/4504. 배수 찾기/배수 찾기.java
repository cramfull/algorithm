
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		multiple mt = new multiple(n);
		
		int k=Integer.parseInt(br.readLine());
		
		while(k!=0) {
			mt.isMultiple(k);
			k = Integer.parseInt(br.readLine());
		}
			
			
			
		
				
	}
}


class multiple{
	int n;
	
	multiple(){
		
	}
	multiple(int n){
		this.n=n;
	}
	
	
	public void isMultiple(int k) {
		if(k%n==0) {
			System.out.println(k + " is a multiple of "+ n+".");
		}else {
			System.out.println(k+" is NOT a multiple of "+ n+".");
		}
	}
	
	
}