
import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static int N;
    static long [] arrA;
    static long [] arrB ;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       
       N = Integer.parseInt(br.readLine());
       arrA = new long[N];
       arrB = new long[N];
       StringTokenizer str = new StringTokenizer(br.readLine());
       for(int i=0;i<N;i++) {
    	   arrA[i]=Long.parseLong(str.nextToken());
       }
       str = new StringTokenizer(br.readLine());
       for(int i=0;i<N;i++) {
    	   arrB[i]=Long.parseLong(str.nextToken());
       }
       
       int result = 0;

       if(Arrays.equals(arrA, arrB)) {
		   result = 1;
	   }
       for(int i=N-1;i>0;i--) {
    	   int maxIdx = i;
    	   for(int j=0; j<i;j++) {
    		   if(arrA[maxIdx]<arrA[j]) {
    			   maxIdx = j;
    		   }
    	   }
    	   if(maxIdx!=i) {
    		   long tmp = arrA[maxIdx];
    		   arrA[maxIdx] = arrA[i];
    		   arrA[i]=tmp;

    		   if(Arrays.equals(arrA, arrB)) {
    			   result = 1;
    		   }
    	   }

       }
       System.out.println(result);
       
    }
   
   
}