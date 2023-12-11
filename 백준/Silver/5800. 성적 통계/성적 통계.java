import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       
       int N = Integer.parseInt(br.readLine());
	       
	       for(int k=1; k<=N; k++) {
	       
	    	   StringTokenizer str = new StringTokenizer(br.readLine());
	       
		       Integer [] arr = new Integer[Integer.parseInt(str.nextToken())];
		       
		       for(int i=0;i<arr.length;i++) {
		    	   arr[i]=Integer.parseInt(str.nextToken());
		       }
		       Arrays.sort(arr, Comparator.reverseOrder());
		       
		       Integer [] arr2 = new Integer[arr.length-1];
		       int largestGap =0;
		       for(int i=0;i<arr2.length;i++) {
		    	   arr2[i] = arr[i]-arr[i+1];
		    	   if(largestGap<arr2[i]) {
		    		   largestGap = arr2[i];
		    	   }
		       }
		       System.out.printf("Class %d", k);
		       System.out.println();
		       System.out.printf("Max %d, Min %d, Largest gap %d", arr[0], arr[arr.length-1], largestGap);
		       System.out.println();
	       }
       
       
       
    }
}