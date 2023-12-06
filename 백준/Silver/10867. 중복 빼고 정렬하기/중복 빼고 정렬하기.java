import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());
       String [] tmp = br.readLine().split(" ");
       
       Set<Integer> set = new TreeSet<>();
       for(int i=0;i<N;i++) {
    	   set.add(Integer.parseInt(tmp[i]));
       }
       for(int s : set) {
    	   System.out.print(s+" ");
       }
    }
}