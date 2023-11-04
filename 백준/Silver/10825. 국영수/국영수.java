
import java.io.*;

import java.util.*;
import java.util.Map.Entry;

//https://vanillacreamdonut.tistory.com/328
//https://devmoony.tistory.com/95
public class Main {	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Member [] arr = new Member[N];
		for(int i=0;i<N;i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			String name = str.nextToken();
			int k = Integer.parseInt(str.nextToken());
			int m = Integer.parseInt(str.nextToken());
			int e = Integer.parseInt(str.nextToken());
			arr[i] = new Member(name, k, m, e);
			
		}
		
		Arrays.sort(arr);
		
		for(int i=N-1;i>=0;i--) {
			System.out.println(arr[i].name);
			
		}
		
	}
	
	static class Member implements Comparable<Member>{
		String name;
		int k,m,e;
		
		public Member(String name, int k, int e, int m) {
			this.name=name;
			this.k=k;
			this.e=e;
			this.m=m;
			
		}


		@Override
		public int compareTo(Member o) {
			if (this.k == o.k) {
	            if (this.e == o.e) {
	                if (this.m == o.m) {
	                    return o.name.compareTo(this.name);
	                }
	                return this.m - o.m;
	            }
	            return o.e - this.e;
	        }
	        return this.k - o.k;
		}

		
	}
}

