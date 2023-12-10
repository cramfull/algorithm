import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int [][] arr = new int[101][101];

       int a,b,c,d;
       a=b=c=d=0;
       for(int i=0; i<4; i++) {
    	   StringTokenizer str = new StringTokenizer(br.readLine());
    	   a = Integer.parseInt(str.nextToken());
    	   b = Integer.parseInt(str.nextToken());
    	   c = Integer.parseInt(str.nextToken());
    	   d = Integer.parseInt(str.nextToken());
    	   
    	   for(int j=a;j<c;j++) {
    		   for(int k=b;k<d;k++) {
    			   arr[j][k]=1;
    		   }
    	   }
       }
       int sum=0;
       for(int i=0;i<arr.length;i++) {
    	   for(int j=0;j<arr.length;j++) {
    		   sum+=arr[i][j];
    	   }
       }
       System.out.println(sum);
       
       
       
    }
}