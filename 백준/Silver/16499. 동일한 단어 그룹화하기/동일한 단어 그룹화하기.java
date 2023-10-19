
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb1 = new StringBuilder();

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	

    	int N = Integer.parseInt(br.readLine());
    	Map<String, Integer > map = new HashMap<>();
    	
    	for(int i=0;i<N;i++) {
    		char [] st = br.readLine().toCharArray();
    		Arrays.sort(st);
    		String s = "";
    		for(int j=0;j<st.length;j++) {
    			s+= st[j];
    		}
    		if(map.containsKey(s)) {
    			map.put(s, map.get(s)+1);
    		}else {
    			map.put(s, 1);
    		}
    		
    	}
    	System.out.println(map.size());
    	
    	
    	
    	
    }
    
    
    
    
    
}