
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb1 = new StringBuilder();

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String s="";
    	
    	while((s = br.readLine())!=null) {
    		StringTokenizer str = new StringTokenizer(s);
    		int n = Integer.parseInt(str.nextToken());
    		int m = Integer.parseInt(str.nextToken());
    		int count = 0;
    		for(int i=n; i<=m; i++) {
        		int [] arr = new int[10];
    			String num = String.valueOf(i);
    			for(int j=0; j<num.length();j++) {
    				arr[Character.getNumericValue(num.charAt(j))]++;
    			}
    			int max = arr[0];
    			for(int j=0;j<arr.length;j++) {
    				if(max<arr[j]) {
    					max=arr[j];
    				}
    			}
    			if(max!=1) {
    				count++;
    			}
    			
    			
    		}
    		int result = m-n+1-count;
    		System.out.println(result);
    		
    		
    		
    	}
    	
    	
    }
    
    
}