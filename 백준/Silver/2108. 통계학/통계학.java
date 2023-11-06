
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int N = Integer.parseInt(br.readLine());
    	
    	int [] arr = new int[N];
    	int sum =0;
    	Map<Integer,Integer> map = new TreeMap<>();

    	for(int i=0;i<N;i++) {
    		int tmp =Integer.parseInt(br.readLine());
    		arr[i] = tmp;
    		sum += arr[i];
    		if(map.containsKey(tmp)) {
    			map.put(tmp, map.get(tmp)+1);
    		}else {
    			map.put(tmp, 1);
    		}
    	}
    	
    	List<Map.Entry<Integer, Integer>> entrylist = new LinkedList<>(map.entrySet());
    	entrylist.sort(new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				if(o2.getValue()==o1.getValue()) {
					return o1.getKey()-o2.getKey();
				}
				return o2.getValue() - o1.getValue();
			}
    	});
    	Arrays.sort(arr);
    	double c1 = (double)sum/(double)N;

    	String s = String.format("%.0f", c1);
       
    	if(s.equals("-0")) {
    		s = "0";
    	}
    	
    	int c2 = arr[N/2];
    	int c3 = 0;
    	
    	if(map.size()==1) {
    		c3 = entrylist.get(0).getKey();
    	}else {
    		if(entrylist.get(0).getValue()==entrylist.get(1).getValue()) {
        		c3 = entrylist.get(1).getKey();
        	}else {
        		c3 = entrylist.get(0).getKey();
        	}
    	}
    	int c4 = arr[N-1]-arr[0];
    	System.out.println(s);
    	System.out.println(c2);
    	System.out.println(c3);
    	System.out.println(c4);
    	
    }
    
    
    
    
}