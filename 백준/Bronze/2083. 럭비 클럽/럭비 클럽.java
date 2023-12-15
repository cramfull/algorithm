
import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
	static int result;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       
       String st = br.readLine();
       while(st.charAt(0)!='#') {
    	   StringTokenizer str = new StringTokenizer(st);
    	   String name = str.nextToken();
    	   int age = Integer.parseInt(str.nextToken());
    	   int weight = Integer.parseInt(str.nextToken());
    	   
    	   
    	   if(age>17 || weight>=80) {
    		   sb.append(name+" Senior"+"\n");
    	   }else {
    		   sb.append(name+" Junior"+"\n");

    	   }
    	   st = br.readLine();
       }
    	   
       System.out.println(sb.toString());
       
    }
}