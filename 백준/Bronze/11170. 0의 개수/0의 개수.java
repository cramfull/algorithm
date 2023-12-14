
import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static int result;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int T = Integer.parseInt(br.readLine());
       
       for(int i=0;i<T;i++) {
    	   StringTokenizer str = new StringTokenizer(br.readLine());
    	   
    	   int st = Integer.parseInt(str.nextToken());
    	   int ed = Integer.parseInt(str.nextToken());
    	   
    	   int sum = 0;
    	   for(int j=st;j<=ed;j++) {
    		   String tmp = String.valueOf(j);
    		   
    		   for(int k=0;k<tmp.length();k++) {
    			   if(tmp.charAt(k)=='0') {
    				   sum++;
    			   }
    		   }
    		   
    	   }
    	   System.out.println(sum);
    	   
    	   
    	   
       }
    	  
    	   
       
    }
}