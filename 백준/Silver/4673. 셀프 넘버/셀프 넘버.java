
import java.io.*;
import java.math.*;
import java.util.*;

public class Main{
	static int N;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       boolean [] arr = new boolean[10001];
      
       int k =1;
       while(selfNum(String.valueOf(k))<=10000) {
    	   int nxt = selfNum(String.valueOf(k));
    	   while(nxt<=10000) {
    		   arr[nxt]=true;
    		   nxt = selfNum(String.valueOf(nxt));
    	   }
    	   k++;
       }
       
       
       
       for(int i=1;i<arr.length-4;i++) {
    	   if(!arr[i]) {
    		   sb.append(i+"\n");
    	   }
       }
       System.out.println(sb.toString());
       
       
    }
    
    static int selfNum(String n) {
    	int selfnum = Integer.parseInt(n);
    	for(int i=0;i<n.length();i++) {
      	  selfnum += Character.getNumericValue(n.charAt(i));
         }
    	return selfnum;
    }
    
    
}
       