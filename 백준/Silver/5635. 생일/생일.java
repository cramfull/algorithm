
import java.util.*;
import java.io.*;
import java.math.*;


public class Main {
	public static void main(String[] args) throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	StringTokenizer str;
	Member[] member = new Member[N];
	for(int i=0;i<N;i++) {
		str = new StringTokenizer(br.readLine());
		String name = str.nextToken();
		int dd = Integer.parseInt(str.nextToken());
		int mm = Integer.parseInt(str.nextToken());
		int yyyy = Integer.parseInt(str.nextToken());
		member[i] = new Member(name, dd, mm, yyyy);
	
	}
	Arrays.sort(member);
	System.out.println(member[N-1].name);
	System.out.println(member[0].name);
	}
	
	static class Member implements Comparable<Member>{
		String name;
		int dd;
		int mm;
		int yyyy;
		
		public Member(String name, int dd, int mm, int yyyy) {
			this.name=name;
			this.dd=dd;
			this.mm=mm;
			this.yyyy=yyyy;
		}
		@Override
		public int compareTo(Member o) {
			if(this.yyyy == o.yyyy) {
				if(this.mm == o.mm) {
					return this.dd - o.dd;
				}
				return this.mm - o.mm;
			}
			return this.yyyy-o.yyyy;
		}
	}
}