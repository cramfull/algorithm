
import java.io.*;
import java.math.*;
import java.util.*;


public class Main {
	static int [] arr;
	static boolean [] checked;
	static int N, M;
	static int [] result;
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(str.nextToken());
    	M = Integer.parseInt(str.nextToken());
    	
    	arr = new int[N];
    	checked = new boolean[N];
    	result = new int[N];
    	str = new StringTokenizer(br.readLine());
    	for(int i=0;i<N;i++) {
    		arr[i]=Integer.parseInt(str.nextToken());
    	}
    	Arrays.sort(arr);
    	backTracking(0, 0);
    	System.out.println(sb.toString());
    	
    	
    	
    	
    	
    }
    static void backTracking(int x, int at) {
    	
    	if(x==M) {
    		for(int i=0;i<M;i++) {
    			sb.append(result[i]+" ");
    		}
    		sb.append("\n");
    		return;
    	}else {
    		for(int i=at;i<N;i++) {
    			int k = arr[i];
    	    	
    	    		result[x]=k;
    	    		backTracking(x+1, i);
    	    	
    	    	
    		}
    	}
    	
    	
    	
    }
    
    
}