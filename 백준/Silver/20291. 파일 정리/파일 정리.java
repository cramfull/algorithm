
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	Map<String, Integer> map = new TreeMap<>();
    	StringTokenizer str;
    	for(int i=0;i<N;i++) {
    		str = new StringTokenizer(br.readLine(),".");
    		String pass = str.nextToken();
    		String s = str.nextToken();
    		if(map.containsKey(s)) {
        		map.put(s, map.get(s)+1);
    		}else {
    			map.put(s, 1);
    		}
    	}
    	for(Map.Entry<String, Integer> result : map.entrySet()) {
    		sb.append(result.getKey()+" "+result.getValue()+"\n");
    	}
    	System.out.println(sb.toString());
    
    
    
   
    	
    }
}