
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(str.nextToken());
    	int K = Integer.parseInt(str.nextToken());
    	
    	int [] arr = new int[N];
    	int [] srr = new int[N];

    	str = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i]=Integer.parseInt(str.nextToken());
    		if(i==0) {
    			srr[i]=arr[i];
    		}else {
    			srr[i]=srr[i-1]+arr[i];
    		}
    	}
    	int max_value = 0;
    	int [] result = new int[N];
    	for(int i=0;i<N-K+1;i++) {
    		if(i==0) {
    			result[i]=srr[K-1];
    			max_value=result[i];
    		}else {
        		result[i]=srr[i+K-1]-srr[i-1];
        		if(result[i]>max_value) {
        			max_value=result[i];
        		}
    		}
    	}
    	System.out.println(max_value);
    	
    	
    	
    	
    	
    	
    	
    
    }



}