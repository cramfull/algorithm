
import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static int result;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int N = Integer.parseInt(br.readLine());
       
       
       for(int i=0;i<N;i++) {
    	   StringTokenizer str = new StringTokenizer(br.readLine());
    	   String s = str.nextToken();
    	   String p = str.nextToken();
    	   if(s.contains(p)) {
    		   s = s.replace(p, "0");
    		   
    	   }
    	   
    	   
    	   System.out.println(s.length());
    	   
       }
    }
    
    
}