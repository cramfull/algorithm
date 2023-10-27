
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	StringTokenizer str = new StringTokenizer(br.readLine(),"-+",true);
    	
    	String [] arr = new String[str.countTokens()];
    	int idx=0;
    	while(str.hasMoreTokens()) {
    		arr[idx++]=str.nextToken();
    	}

    	int result = 0;
    	
    	for(int i=0;i<arr.length;i++) {
    		if((i+1)%2==0) {
    			if(arr[i].equals("-")) {
    				if(i+2<arr.length-1) {
    					arr[i+2]="-";
    				}
    			}	
    		}
    	}
    	int sum=Integer.parseInt(arr[0]);
    	for(int i=0;i<arr.length;i++) {
    		if((i+1)%2==0) {
    			if(arr[i].equals("-")) {
    				sum-=Integer.parseInt(arr[i+1]);
    			}else {
    				sum+=Integer.parseInt(arr[i+1]);
    			}
    		}
    	}
    	System.out.println(sum);
    	
    	
    	
    }
}