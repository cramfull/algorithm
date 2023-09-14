

import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		Member [] arr = new Member[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Member(x,y);

		}
		Arrays.sort(arr);
		
		for(Member mem : arr)
		System.out.println(mem.x+" "+mem.y);
		
	}
	

	
	
}

class Member implements Comparable<Member>{
	int x;
	int y;
	
	public Member(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Member o) {
		// TODO Auto-generated method stub
		if(x==o.x) {
			return y-o.y;
		}
		return x-o.x;
	}
	
	
	
}