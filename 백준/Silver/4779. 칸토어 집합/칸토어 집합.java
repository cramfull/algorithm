
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String input = "";
    	
    	
    	while((input = br.readLine())!=null) {
    		sb = new StringBuilder();
        	int n = Integer.parseInt(input);

        	n = (int)Math.pow(3, n);
        	
        	for(int i=0;i<n;i++) {
        		sb.append('-');
        	}
        	
        	kantoa(0,n);
        	System.out.println(sb.toString());
        	
    		
    		
    	}
    	
    	
    	
    }
    
    
    static void kantoa(int st, int ed) {
    	int from = st+(ed-st)/3;
    	int to = st+2*(ed-st)/3;
    	// 기저 조건

    	if(st>=from || to>=ed) {
    		return;
    	}
    	
    	for(int i=from; i<to; i++) {
    		sb.setCharAt(i, ' ');
    	}
    	// 반복 조건 
    	
    	
    	kantoa(st,from);
    	
    	kantoa(to,ed);
    }
}
