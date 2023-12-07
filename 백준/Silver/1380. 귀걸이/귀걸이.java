import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int n = Integer.parseInt(br.readLine());
       int tc = 1;
       while(n!=0) {
    	   Member [] member = new Member[n];
    	   
    	   for(int i=0;i<n;i++) {
    		   member[i]=new Member(br.readLine(),1);
    	   }
    	   for(int i=0;i<2*n-1;i++) {
    		   StringTokenizer str = new StringTokenizer(br.readLine());
    		   int order = Integer.parseInt(str.nextToken())-1;
    		   member[order].check++;
    	   }
    	   for(int i=0;i<n;i++) {
    		   if(member[i].check==2) {
    	    	   System.out.println(tc+" "+member[i].name);
    		   }
    	   }
    	   tc++;
    	   n = Integer.parseInt(br.readLine());
       }
       
       
       
       
       
    }
    
    static class Member{
    	String name;
    	int check;
    	
    	public Member(String name, int check) {
    		this.name=name;
    		this.check=check;
    	}
    }
}