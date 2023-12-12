import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


       
       int N = Integer.parseInt(br.readLine());
       
       for(int i=0;i<N;i++) {
	       StringTokenizer str = new StringTokenizer(br.readLine());
	       long a = Long.parseLong(str.nextToken());
	       long b= Long.parseLong(str.nextToken());
	       long gcd =  gcd((long)Math.max(a, b), (long)Math.min(a, b));
	       if(gcd==1) {
	    	   System.out.println(a*b);
	       }else {
	    	   System.out.println(a/gcd*b/gcd*gcd);
	       }
       }
       
       
    }
    
    static long gcd(long a, long b) {
    	long r = a%b;
    	if(r==0) {
    		return b;
    	}else {
    		return gcd(b, r);
    	}
    }
    
    
    
}