
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	
    	
    	String input = "";
    	
    	while((input = br.readLine())!= null) {

        	StringTokenizer str = new StringTokenizer(input);
        	
        	String s = str.nextToken();
        	String t = str.nextToken();
    		System.out.println(sub(s,t));
        	
        	
        	
        	
    		
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    }
    static String sub(String s, String t) {
    	boolean [] arr = new boolean[s.length()];
		int at = 0;
    	for(int i=0;i<s.length();) {
    		for(int j=at;j<t.length();j++) {
        		char sChar=s.charAt(i);
    			char tChar = t.charAt(j);
    			if(sChar==tChar) {
    				arr[i]=true;
        			at = j;
        			i++;
        			if(i==s.length()) {
        				break;
        			}
    			}
    			
    		}
    		i++;
    	}
    	for(int i=0;i<arr.length;i++) {
    		if(!arr[i]) {
    			
    			return "No";
    		}
    	}
    	return "Yes";
    	
    	
    }
    
    
    
    
    
}

