
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	Scanner scn = new Scanner(System.in);
    	Map<String, Integer> map = new TreeMap<>();
    	
    	String input = "";
    	float count = 0;
    	
    	while(scn.hasNextLine()) {
    		input = scn.nextLine();
    		if(map.containsKey(input)){
        		map.put(input, map.get(input)+1);    			
    		}else {
    			map.put(input, 1);
    		}
    		
    		count++;

    	
    		
    	}
    	
    		
    	
    	List<Map.Entry<String, Integer>> entry = new ArrayList<Entry<String,Integer>>(map.entrySet());

    	Collections.sort(entry, new Comparator<Entry<String,Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getKey().compareTo(o2.getKey());
			}
    	});
    	for(Entry<String, Integer> list : entry) {
    		float result = (float)list.getValue()/count*100;
    		System.out.println(""+String.valueOf(list.getKey())+" "+String.format("%.4f", result));
    	}
    	
    }
}
