
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static boolean [] visited;
	static int arr [] ;
	static int k;
	static int [] result=new int[7];
	
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	
    	k = Integer.parseInt(str.nextToken());
   
    	while(k!=0){
    	 	arr = new int[k+1];
        	visited = new boolean[k+1];
    		for(int i=1;i<=k;i++) {
    			arr[i]=Integer.parseInt(str.nextToken());   			
    		}
    		backTracking(1, 0);
    		sb.append("\n");
    		str = new StringTokenizer(br.readLine());
        	k = Integer.parseInt(str.nextToken());
    	}
    	System.out.println(sb.toString());
    	
    	
    	
    }
    static void backTracking(int at, int x) {
    	if(x==6) {
    		for(int i=0;i<6;i++) {
    			sb.append(result[i]+" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i=at;i<=k;i++) {    		
    		if(!visited[i]) {
        		visited[i] = true;
        		result[x] = arr[i];
        		backTracking(i,x+1);
        		visited[i] = false;
        	}
    	}
    	
    	
    	
    	
    	
    	
    }
    
    
}