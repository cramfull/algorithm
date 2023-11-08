import java.io.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer str = new StringTokenizer(br.readLine());
       
       int A = Integer.parseInt(str.nextToken());
       int B = Integer.parseInt(str.nextToken());
       int V = Integer.parseInt(str.nextToken());
       
       
       if((V-B)%(A-B)!=0) {
    	   System.out.println((V-B)/(A-B)+1);
       }else {
           System.out.println((V-B)/(A-B));
       }
       
       
    }
}