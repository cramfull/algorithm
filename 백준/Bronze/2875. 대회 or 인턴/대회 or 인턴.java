
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		int K = scn.nextInt();
		
		int count = 0;
		
		while(N>=2 && M>=1 && N+M >=3+K){
            N -= 2;
            M-=1;
            count++;
        }
        System.out.println(count);
		
		
		
		
		
		
	}
}