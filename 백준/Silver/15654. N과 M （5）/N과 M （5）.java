
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	
	static int N, M;
	static int [] value;
	static int [] result;
	static boolean visited[];
	
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer str = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(str.nextToken());
    	M = Integer.parseInt(str.nextToken());
    	str = new StringTokenizer(br.readLine());
    	value = new int[N];
    	result = new int[N];
    	visited = new boolean[N];
    	
    	for(int i=0;i<N;i++) {
    		value[i] = Integer.parseInt(str.nextToken());
    	}
    	Arrays.sort(value);
    	backTracking(0);
    	System.out.println(sb.toString());
    	
    }
    static void backTracking(int x) {
    	if(x==M) {
    		for(int i=0;i<M;i++) {
    			sb.append(result[i]+" ");
       		}
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i=0;i<N;i++) {
    		int k = value[i];
    		if(!visited[i]) {
    			result[x]=k;
    			visited[i] = true;
        		backTracking(x+1);
        		visited[i] = false;
    		}
    	}
    	
    	
    	
    	
    	
    	
    }
}
