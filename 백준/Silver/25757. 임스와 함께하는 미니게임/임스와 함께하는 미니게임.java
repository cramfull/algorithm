import java.io.*;
import java.math.*;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer str = new StringTokenizer(br.readLine());
       
       int N = Integer.parseInt(str.nextToken());
       char k = str.nextToken().charAt(0);
       int player=0;
       switch(k) {
       	   case 'Y':
    	   player=1;
    	   break;
       	   case 'F':
       	   player=2;
       	   break;
       	   case 'O':
       		 player =3;
       }
       Set<String> set = new HashSet<>();
       for(int i=0;i<N;i++) {
    	   set.add(br.readLine());
       }
       int num = set.size();
       
       System.out.println(num/player);
       
       
    }
}