
import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str = new StringTokenizer(br.readLine());		
		
		int A = Integer.parseInt(str.nextToken());
		int B = Integer.parseInt(str.nextToken());
		
		System.out.println(B-A+" "+B);
		
	}

}
