
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		long Min = 0;
		
		long km []= new long[N-1]; 
		for(int i=0; i<N-1; i++) {
			km[i] = scn.nextLong();
		}
		
		long cost [] = new long[N];
		for(int i=0; i<N; i++) {
			cost[i] = scn.nextLong();
		}
		for(int i=0; i<N-1; i++) {
			if(cost[i]<cost[i+1]) {
				Min+=cost[i]*km[i]+cost[i]*km[i+1];
				i++;
			}else {
				Min += cost[i]*km[i];
			}
		}
		System.out.println(Min);
		
		
		
		
		
		
	}
}