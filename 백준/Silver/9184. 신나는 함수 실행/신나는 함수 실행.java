import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	static int [][][] w = new int [21][21][21];
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
    	while(true) {
        	StringTokenizer str = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(str.nextToken());
        	int b = Integer.parseInt(str.nextToken());
        	int c = Integer.parseInt(str.nextToken());
        	
        	if(a==-1 && b==-1 && c==-1) {
        		break;
        	}
        	sb.append("w("+a+", "+b+", "+c+") = "+w(a,b,c)).append("\n"); 
     
    	}
    	System.out.println(sb.toString());

    	
    	
    	
    	
    }
    
    static int w(int a,int b,int c) {
    	
    	if(a<=0||b<=0||c<=0) {
    		return 1;
    	}
    	if(a>20 || b>20 || c>20) {
    		return w[20][20][20] = w(20,20,20);
    	}
    	if(w[a][b][c]!=0) {
    		return w[a][b][c];
    	}
    	
    	if(a<b && b<c) {
    		return w[a][b][c] = w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
    	}
    	
    	return w[a][b][c]=w(a-1,b,c)+w(a-1,b-1,c)+w(a-1,b,c-1)-w(a-1,b-1,c-1);
    	
    	
    }
}