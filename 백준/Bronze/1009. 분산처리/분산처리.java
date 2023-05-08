

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int ex(int a, int b) {
		
		switch(a%10) {
		case 1:
		return 1;
		case 2:
			int [] two = {2, 4, 8, 6};
			if(b%4==0) {
				return two[3];
			}else {
				return two[b%4-1];
			}
		case 3:
			int [] three = {3, 9, 7, 1};
			if(b%4==0) {
				return three[3];
			}else {
				return three[b%4-1];
			}
		case 4:
			int [] four = {4, 6};
			if(b%2==0) {
				return four[1];
			}else {
				return four[b%2-1];
			}
		case 5:
			return 5;
		case 6:
			return 6;
		case 7:
			int [] seven = {7, 9, 3, 1};
			if(b%4==0) {
				return seven[3];
			}else {
				return seven[b%4 -1];
			}
		case 8:
			int [] eight = {8, 4, 2, 6};
			if(b%4 ==0) {
				return eight[3];
			}else {
				return eight[b%4 -1];
			}
		case 9:
			int [] nine = {9, 1};
			if(b%2==0) {
				return nine[1];
			}else {
				return nine[b%2-1];
			}
		default:
			return 10;
		}
		
		
		
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer str;
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			str = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(str.nextToken());
			int b = Integer.parseInt(str.nextToken());
			System.out.println(Main.ex(a,b));
			
		}
		
		
		
		
	}
}


