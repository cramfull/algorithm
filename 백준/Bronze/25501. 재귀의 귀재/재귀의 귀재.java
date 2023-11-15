
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			String st = br.readLine();
			System.out.println(isPalindrome(st)+" "+count);
			
		}
		
		
	}
	
	
	public static int recursion(String s, int l, int r) {
		count++;
		if(l>=r) {
			return 1;
		}else if(s.charAt(l)!=s.charAt(r)) {
			return 0;
		}else {
			return recursion(s,l+1,r-1);
		}
		
	}
	public static int isPalindrome(String s) {
		count=0;
		return recursion(s,0,s.length()-1);
	}
}