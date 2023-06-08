
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int Min = 0;
		
		int km []= new int[N-1]; 
		for(int i=0; i<N-1; i++) {
			km[i] = scn.nextInt();
		}
		
		int cost [] = new int[N];
		for(int i=0; i<N; i++) {
			cost[i] = scn.nextInt();
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