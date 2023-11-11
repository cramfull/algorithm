import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       int N = Integer.parseInt(br.readLine());
       
       BigInteger [] fibo = new BigInteger[N+3];
       
       fibo[0]=new BigInteger("0");
       fibo[1]=new BigInteger("1");
       
       if(N==0) {
    	   bw.write("0");
       }else if(N==1) {
    	   bw.write("1");
       }else {
    	   for(int i=2;i<=N;i++) {
    		   fibo[i]=fibo[i-1].add(fibo[i-2]);
    	   }
    	   bw.write(String.valueOf(fibo[N]));
       }
       bw.flush();
       bw.close();
       
       
       
    }
   
    
    
    
}