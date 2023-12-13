import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static int result;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int N = Integer.parseInt(br.readLine());
       
       StringTokenizer str = new StringTokenizer(br.readLine());
       long sum =0;
	   long k = N-1;

       long sumN =0;
       while(str.hasMoreTokens()) {
    	   sum+= Integer.parseInt(str.nextToken());
    	   sumN += k--;
       }
              
       System.out.println(sum-sumN);
       
       
       
    }
}